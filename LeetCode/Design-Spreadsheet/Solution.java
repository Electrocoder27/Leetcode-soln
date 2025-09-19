class Spreadsheet {

    private int[][] grid; // rows × 26

    public Spreadsheet(int rows) {
        grid = new int[rows][26]; // default 0
    }

    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A'; // 0-based
        int row = Integer.parseInt(cell.substring(1)) - 1; // 0-based
        return new int[]{row, col};
    }

    public void setCell(String cell, int value) {
        int[] rc = parseCell(cell);
        grid[rc[0]][rc[1]] = value;
    }

    public void resetCell(String cell) {
        int[] rc = parseCell(cell);
        grid[rc[0]][rc[1]] = 0;
    }

    public int getValue(String formula) {
        if (formula.charAt(0) != '=') {
            throw new IllegalArgumentException("Formula must start with =");
        }
        String expr = formula.substring(1); // drop '='
        String[] parts = expr.split("\\+");
        int sum = 0;
        for (String part : parts) {
            part = part.trim();
            if (Character.isDigit(part.charAt(0))) {
                sum += Integer.parseInt(part);
            } else {
                int[] rc = parseCell(part);
                sum += grid[rc[0]][rc[1]];
            }
        }
        return sum;
    }
}
