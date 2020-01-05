//
//  SearchInRotatedArrayAnswerOne.swift
//  NQueens
//
//  Created by 张东坡 on 2020/1/1.
//  Copyright © 2020 张东坡. All rights reserved.
//

import Foundation
class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        if nums.count == 0 {
            return -1
        } else if nums.count == 1{
            return nums[0] == target ? 0 : -1
        }
        // find rotate index
        let rotatedIndex = findRotatedIndex(nums)
        
        // binary search
        let index = binarySearch(with: rotatedIndex, target, nums)
        return index
        
    }
    
    private func findRotatedIndex(_ nums:[Int]) -> Int {
        var left = 0
        var right = nums.count - 1
        if nums[left] < nums[right] {
            return 0
        }
        while left <= right {
            let mid = (left + right) / 2
            if nums[mid] > nums[mid + 1] {
                return mid + 1;
            } else {
                if nums[mid] > nums[left]{
                    left = mid + 1
                } else {
                    right = mid;
                }
            }
        }
        return -1
    }
    
    private func binarySearch(with rotatedIndex: Int,  _ target: Int, _ nums:[Int]) -> Int {
        var left = 0
        var right = nums.count - 1
        
        if target <= nums[right] {
            left = rotatedIndex
        } else if target >= nums[left] {
            right = rotatedIndex - 1;
        } else {
            return -1;
        }
        while left <= right {
            let mid = (left + right) / 2
            if nums[mid] == target {
                return mid;
            } else if nums[mid] > target{
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1;
    }
}
