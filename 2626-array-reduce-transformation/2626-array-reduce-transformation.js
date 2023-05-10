/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let res = init;
    for(let i = 0; i < nums.length; i++){
        res = fn(init, nums[i]);
        init = res;
    }
    
    return res;
};