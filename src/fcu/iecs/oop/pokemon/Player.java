package fcu.iecs.oop.pokemon;

public class Player
{
	private String  playerName;
    private int     level;
    private Pokemon[] Pokemons;
    
	
	public String getPlayerName() {
		return playerName;
	}

    public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

    public int getLevel() {
		return level;
	}

    public void setLevel(int level) 
    {
		this.level = level;
	}
    public int getPokemonsCP(int a)//�i�H��X�ڭ̩ҭn���d�� CP
    {
    	return Pokemons[a].getCp();
    }
 
    public Pokemon[] getPokemons() 
    {
    
    	return Pokemons; 
    }
    
    public String getPokemons(int a)//�i�H��X�ڭ̩ҭn���d�� �W�r
    {
    	return Pokemons[a].getName();
    }
    
    public PokemonType getPokemonsType(int a)//�i�H��X�ڭ̩ҭn���d�� �ݩ�
    {
    	return Pokemons[a].getType();
    }
    
    public void showPokemons()
    {
    	for(Pokemon mon : Pokemons )
    	{	
    		 System.out.printf("%10s    %s\n",mon.getName(),mon.getType()); 
    	}
    }
    public void setPokemons(Pokemon[] pokemons) {
		Pokemons = pokemons;
	}
    
    Player(String name)
	{
		this.playerName = name;
		this.level = 1;
	}
}