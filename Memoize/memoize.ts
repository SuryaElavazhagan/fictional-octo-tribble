// https://leetcode.com/problems/memoize/description/

type Fn = (...params: any) => any

function memoize(fn: Fn): Fn {
    let memoized_map: Map<string, any> = new Map();
    return function(...args) {
        if (memoized_map.has(args.toString())) {
            return memoized_map.get(args.toString());
        }
        let value = fn(...args);
        memoized_map.set(args.toString(), value);
        return value;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */