//
//  NQueens.swift
//  NQueens
//
//  Created by 张东坡 on 2020/1/1.
//  Copyright © 2020 张东坡. All rights reserved.
//

import Foundation

class Solution {
    // 皇后可能攻击的地方
    private var cols = Set<Int>()
    private var pie = Set<Int>()
    private var na = Set<Int>()
    
    // 皇后个数
    private var n: Int = 0
    
    // 搜索到的结果
    private var searchResult = [[Int]]()
    // 遍历一次的结果
    private var currentResult = [Int]()
    
    func solveNQueens(_ n: Int) -> [[String]] {
        self.n = n
        // 搜索结果
        dfs(with: 0)
        // 生成结果
        return generateResult();
    }
    
    private func dfs(with row:Int) {
        if row >= n {
            searchResult.append(currentResult)
            return
        }
        for col in 0 ..< n {
            if isUnderAttack(row: row, col: col) {
                continue
            }
            cols.insert(col)
            pie.insert(row + col)
            na.insert(row - col)
            currentResult.append(col)
            
            dfs(with: row + 1)
            
            cols.remove(col)
            pie.remove(row + col)
            na.remove(row - col)
            currentResult.removeLast()
        }
    }
    
    private func isUnderAttack(row: Int, col: Int) -> Bool {
        return self.cols.contains(col) || self.pie.contains(row + col) || self.na.contains(row - col)
    }
    
    private func generateResult() -> [[String]] {
        return searchResult.map { (item) -> [String] in
            return item.map { (queenPostion) -> String in
                var string = ""
                for i in 0 ..< n {
                    if i == queenPostion {
                        string += "Q"
                    } else {
                        string += "."
                    }
                }
                return string
            }
        }
    }
}
