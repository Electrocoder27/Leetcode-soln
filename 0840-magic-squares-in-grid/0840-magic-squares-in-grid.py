class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        count = 0
        n = len(grid) 
        m = len(grid[0]) 

        def ismagic(r,c):
            nums = set() ;#used to store unique elements...........
            for i in range(r,r+3):
                for j in range(c,c+3):
                    val = grid[i][j] 
                    nums.add(val)
                    if val<1 or val>9 :
                        return False 
            
            if len(nums) != 9 : 
                return Flse 

            s = sum(grid[r][c:c+3]) #first row.......

            #checking rows..........
            for i in range(r,r+3):
                if sum(grid[i][c:c+3]) != s :
                    return False
            
            #checking columns..........
            for j in range(c,c+3):
                if grid[r][j]+grid[r+1][j]+grid[r+2][j] != s:
                    return False 
            #checking diagonals........
            if grid[r][c] + grid[r+1][c+1] +grid[r+2][c+2] != s:
                return False 
            if grid[r][c+2] +grid[r+1][c+1] +grid[r+2][c] != s :
                return False 

            return True 

        for r in range(n-2):
            for c in range(m-2):
                if ismagic(r,c):
                    count +=1 

        return count 