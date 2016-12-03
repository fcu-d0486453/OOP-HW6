package fcu.iecs.oop.pokemon;

import java.util.Scanner;

public class Pokemon
{
	private final String  name ;
	private int           cp;
    private final PokemonType   Type;
    
    Pokemon(final String name,final PokemonType Type, int cp ) {//建構子
		this.name = new String(name);
		this.Type = Type;
		this.cp = cp;
	}
    
    
    public PokemonType getType() {
		return this.Type;
	}

    public  String getName() {
		return name;
	}
    
	
	public  int getCp() {
		return cp;
	}

	public  void setPlus500Cp() {
		this.cp += 500;
	}
	public  void setCp() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("請輸入想增加的數值: ");
		int a;
		while( true )
		{
			a = sc.nextInt();
			if( sc.hasNextInt(a) )
			{
				this.cp += a ;	
			    break;
			}
			else
			{
				System.out.println("此輸入不為整數 請重新輸入");
			    sc.reset();
			}
		}
		
		sc.close();
		
	}
}
