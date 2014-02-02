package com.shark.concurrenthashmap;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class ConHashMap<K, V> {
	static final int DEFAULT_INITIAL_CAPACITY = 16;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	static final int DEFAULT_CONCURRENCY_LEVEL = 16;
	
	static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int MAX_SEGMENTS = 1 << 16;
    static final int RETRIES_BEFORE_LOCK = 2;
    final int segmentMask;
    final int segmentShift;
	
	final Segment<K, V>[] segments;
    Set<K> keySet;
    Set<Map.Entry<K, V>> entrySet;
    Collection<V> values;
    
    private static int hash(int h) {
		h += (h <<  15) ^ 0xffffcd7d;
		h ^= (h >>> 10);
		h += (h <<   3);
		h ^= (h >>>  6);
		h += (h <<   2) + (h << 14);
		return h ^ (h >>> 16);
	}
    
	static final class HashEntry<K,V> {
        final K key;
        final int hash;
        volatile V value;
        final HashEntry<K,V> next;

        HashEntry(K key, int hash, HashEntry<K,V> next, V value) {
            this.key = key;
            this.hash = hash;
            this.next = next;
            this.value = value;
        }

        @SuppressWarnings("unchecked")
        static final <K,V> HashEntry<K,V>[] newArray(int i) {
            return new HashEntry[i];
        }
    }
	
	static final class Segment<K,V> extends ReentrantLock implements Serializable {
		private static final long serialVersionUID = 1L;

		int count;
        int modCount;
        int threshold;
        HashEntry<K,V>[] table;
        final float loadFactor;

        Segment(int initialCapacity, float lf) {
            loadFactor = lf;
            setTable(HashEntry.<K,V>newArray(initialCapacity));
        }

        @SuppressWarnings("unchecked")
        static final <K,V> Segment<K,V>[] newArray(int i) {
            return new Segment[i];
        }


        void setTable(HashEntry<K,V>[] newTable) {
            threshold = (int)(newTable.length * loadFactor);
            table = newTable;
        }

        HashEntry<K,V> getFirst(int hash) {
            HashEntry<K,V>[] tab = table;
            return tab[hash & (tab.length - 1)];
        }

        
        V readValueUnderLock(HashEntry<K,V> e) {
            lock();
            try {
                return e.value;
            } finally {
                unlock();
            }
        }

        
        V get(Object key, int hash) {
            if (count != 0) { // read-volatile
                HashEntry<K,V> e = getFirst(hash);
                while (e != null) {
                    if (e.hash == hash && key.equals(e.key)) {
                        V v = e.value;
                        if (v != null)
                            return v;
                        return readValueUnderLock(e); // recheck
                    }
                    e = e.next;
                }
            }
            return null;
        }

        
        boolean containsKey(Object key, int hash) {
            if (count != 0) { // read-volatile
                HashEntry<K,V> e = getFirst(hash);
                while (e != null) {
                    if (e.hash == hash && key.equals(e.key))
                        return true;
                    e = e.next;
                }
            }
            return false;
        }

        
        boolean containsValue(Object value) {
            if (count != 0) { // read-volatile
                HashEntry<K,V>[] tab = table;
                int len = tab.length;
                for (int i = 0 ; i < len; i++) {
                    for (HashEntry<K,V> e = tab[i]; e != null; e = e.next) {
                        V v = e.value;
                        if (v == null) // recheck
                            v = readValueUnderLock(e);
                        if (value.equals(v))
                            return true;
                    }
                }
            }
            return false;
        }
        
	}
	
	final Segment<K, V> segmentFor(int hash) {
		return segments[(hash >>> segmentShift) & segmentMask];
	}
	
	public ConHashMap(int initialCapacity,
            float loadFactor, int concurrencyLevel) {
		if (!(loadFactor > 0) || initialCapacity < 0 || concurrencyLevel <= 0)
			throw new IllegalArgumentException();

		if (concurrencyLevel > MAX_SEGMENTS)
			concurrencyLevel = MAX_SEGMENTS;

		// Find power-of-two sizes best matching arguments
		int sshift = 0;
		int ssize = 1;
		while (ssize < concurrencyLevel) {
			++sshift;
			ssize <<= 1;
		}
		
		segmentShift = 32 - sshift;
		segmentMask = ssize - 1;
		this.segments = Segment.newArray(ssize);
		
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		int c = initialCapacity / ssize;
		if (c * ssize < initialCapacity)
			++c;
		int cap = 1;
		while (cap < c)
			cap <<= 1;
		
		for (int i = 0; i < this.segments.length; ++i)
		this.segments[i] = new Segment<K,V>(cap, loadFactor);
	}
		
		public ConHashMap(int initialCapacity, float loadFactor) {
			this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
		}
		
		public ConHashMap(int initialCapacity) {
			this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
		}
		
		public ConHashMap() {
			this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
		}
}

