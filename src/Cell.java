public enum Cell{	
	ALIVE {
		public Cell validate(int aliveNeighbors){
			if (aliveNeighbors < 2 || aliveNeighbors > 3){
				return DEAD;
			}
			return this;
		}
	},
	DEAD {
		public Cell validate(int aliveNeighbors){
			if (aliveNeighbors == 3 || aliveNeighbors == 2){
				return ALIVE;
			}
			return this;
		}
	};
	
	public abstract Cell validate(int aliveNeighbors);
}

