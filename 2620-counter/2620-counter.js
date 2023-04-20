/**
 * @param {number} n
 * @return {Function} counter
 */

var createCounter = function(n) {
    let count = 0;
    return function() {
        let ans = n + count;
        count++;
        return ans;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */