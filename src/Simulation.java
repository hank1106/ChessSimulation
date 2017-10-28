import java.util.*;

public class Simulation {
	public static class Position
	{
		public int i;
		public int j;
		public Position(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
	
	public static int[] possibleMovesI = {-1, -2, -2, -1, 1, 2, 2, 1};
	public static int[] possibleMovesJ = {-2, -1, 1, 2, -2, -1, 1, 2};
	public static int T = 512;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] chess = new int[4][4];
		int init = 0;
		for(int i = 0; i < chess.length; i++)
		{
			for(int j = 0; j < chess[0].length; j++)
			{
				chess[i][j] = init;
				init++;
			}
		}
		
		int sum = 0;
		Position curr = new Position(0, 0);
		for(int i = 0; i < T; i++)
		{
			sum += chess[curr.i][curr.j];
			System.out.println("position: " + curr.i + " " + curr.j);
			System.out.println("Key value: " + chess[curr.i][curr.j]);
			System.out.println("sum: " + sum);
			List<Position> moves = new ArrayList<Position>();
			for(int k = 0; k < possibleMovesI.length; k++)
			{
				int nextI = curr.i + possibleMovesI[k];
				int nextJ = curr.j + possibleMovesJ[k];
				Position nextPos = new Position(nextI, nextJ);
				if(inBounds(chess, nextPos))
				{
					moves.add(nextPos);
				}
			}
			Random rand = new Random();
			int randomMove = rand.nextInt(moves.size());
			curr = moves.get(randomMove);
		}
		
	}
	
	public static boolean inBounds(int[][] board, Position p)
	{
		if(board == null)
		{
			return false;
		}
		return p.i < board.length && p.i >= 0 && p.j < board[0].length && p.j >= 0;
	}

}
