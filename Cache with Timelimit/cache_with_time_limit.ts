// https://leetcode.com/problems/cache-with-time-limit/description/

class TimeLimitedCache {
    private cache: Map<number, number>;
    private timerMap: Map<number, any>;
    constructor() {
        this.cache = new Map();
        this.timerMap = new Map();
    }

    set(key: number, value: number, duration: number): boolean {
        const doesKeyExist = this.cache.has(key);
        if (doesKeyExist) {
            clearTimeout(this.timerMap.get(key));
        }
        this.cache.set(key, value);
        let timerID = setTimeout(() => {
            this.cache.delete(key);
        }, duration);
        this.timerMap.set(key, timerID);
        return doesKeyExist;
    }

    get(key: number): number {
        return this.cache.get(key) ?? -1;
    }

	count(): number {
        return this.cache.size;
    }
}

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */