package fcu.iecs.oop.pokemon;

import java.util.Random;

public  class GYM
{
	public static void Fight(Player... players)
	{
		System.out.println("參賽者有:");
		System.out.println("================================");
		
		for( int i=0 ; i<players.length ; i++ )
		{
			System.out.printf("LV:%2d  Name: %s\n"
					,players[i].getLevel(),players[i].getPlayerName());
			
			System.out.printf("此玩家擁有下列 Pokemon: \n");
			players[i].showPokemons();
			System.out.println("================================");
		}
		
		int p1Point=0,p2Point=0;//比賽積分
		for( int i=0 ; i<3 ; i++ )//比賽比 3 場
		{
			if( players[0].getPokemonsType(i) != players[1].getPokemonsType(i) )//第 i 隻屬性
			{                             //無相同的屬性比較 所以只剩下 2 種條件
				if( players[0].getPokemonsType(i).equals(PokemonType.FIRE ) &&//P1 火 贏
					players[1].getPokemonsType(i).equals(PokemonType.GRASS)	 )
				{
					System.out.printf("%s 的  %s 獲勝!!\n"
							,players[0].getPlayerName(),players[0].getPokemons(i));
					p1Point++;
				}
				else if( players[0].getPokemonsType(i).equals(PokemonType.GRASS ) &&//P1 草 贏
						players[1].getPokemonsType(i).equals(PokemonType.WATER)	 )
					{
						System.out.printf("%s 的  %s 獲勝!!\n"
								,players[0].getPlayerName(),players[0].getPokemons(i));
						p1Point++;
					}
				else if( players[0].getPokemonsType(i).equals(PokemonType.WATER ) &&//P1 水 贏
						players[1].getPokemonsType(i).equals(PokemonType.FIRE)	 )
					{
						System.out.printf("%s 的  %s 獲勝!!\n"
								,players[0].getPlayerName(),players[0].getPokemons(i));
						p1Point++;
					}
				else//剩下 只有 P2 會贏了
				{
					System.out.printf("%s 的  %s 獲勝!!\n"
							,players[1].getPlayerName(),players[1].getPokemons(i));
					p2Point++;
				}
			}
			else if(  players[0].getPokemonsCP(i)
					!=players[1].getPokemonsCP(i)  )//CP 不一樣
			{
				if( players[0].getPokemonsCP(i)>players[1].getPokemonsCP(i) )
				{
					System.out.printf("%s 的  %s 獲勝!!\n"
							,players[0].getPlayerName(),players[0].getPokemons(i));
					p1Point++;
				}
				else
				{
					System.out.printf("%s 的  %s 獲勝!!\n"
							,players[1].getPlayerName(),players[1].getPokemons(i));
					p2Point++;
				}
			}
			else// 經過上面兩個條件篩選 此條件發生前提為"屬性一樣&&CP一樣"  
			{
				Random ran = new Random();
				int a = ran.nextInt(2)+1;
				
				    if(  (a%2) == 0 )
				    {
				    	System.out.printf("%s 的  %s 獲勝!!\n"
								,players[0].getPlayerName(),players[0].getPokemons(i));
						p1Point++;
				    }
				    else
				    {
				    	System.out.printf("%s 的  %s 獲勝!!\n"
								,players[1].getPlayerName(),players[1].getPokemons(i));
						p2Point++;
				    }
			}
			
		
		}
		if(  p1Point!=p2Point
		  && p1Point>p2Point)//P1 贏
		{
			System.out.println("\""+players[0].getPlayerName()+"\""+"獲勝!!");
			int L = players[0].getLevel();
			players[0].setLevel( L+1 ); //Level up
			System.out.printf("%s 升級至 LV: %2d 等\n"
					,players[0].getPlayerName(),players[0].getLevel());
		}
		
		else
		{
			System.out.println("\""+players[1].getPlayerName()+"\""+"獲勝!!");
			int L = players[1].getLevel();
			players[1].setLevel( L+1 );
			System.out.printf("%s 升級至 LV: %2d 等\n"
					,players[1].getPlayerName(),players[1].getLevel());
		}
	
	}
}
