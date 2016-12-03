package fcu.iecs.oop.pokemon;

import java.util.Random;

public  class GYM
{
	public static void Fight(Player... players)
	{
		System.out.println("���ɪ̦�:");
		System.out.println("================================");
		
		for( int i=0 ; i<players.length ; i++ )
		{
			System.out.printf("LV:%2d  Name: %s\n"
					,players[i].getLevel(),players[i].getPlayerName());
			
			System.out.printf("�����a�֦��U�C Pokemon: \n");
			players[i].showPokemons();
			System.out.println("================================");
		}
		
		int p1Point=0,p2Point=0;//���ɿn��
		for( int i=0 ; i<3 ; i++ )//���ɤ� 3 ��
		{
			if( players[0].getPokemonsType(i) != players[1].getPokemonsType(i) )//�� i ���ݩ�
			{                             //�L�ۦP���ݩʤ�� �ҥH�u�ѤU 2 �ر���
				if( players[0].getPokemonsType(i).equals(PokemonType.FIRE ) &&//P1 �� Ĺ
					players[1].getPokemonsType(i).equals(PokemonType.GRASS)	 )
				{
					System.out.printf("%s ��  %s ���!!\n"
							,players[0].getPlayerName(),players[0].getPokemons(i));
					p1Point++;
				}
				else if( players[0].getPokemonsType(i).equals(PokemonType.GRASS ) &&//P1 �� Ĺ
						players[1].getPokemonsType(i).equals(PokemonType.WATER)	 )
					{
						System.out.printf("%s ��  %s ���!!\n"
								,players[0].getPlayerName(),players[0].getPokemons(i));
						p1Point++;
					}
				else if( players[0].getPokemonsType(i).equals(PokemonType.WATER ) &&//P1 �� Ĺ
						players[1].getPokemonsType(i).equals(PokemonType.FIRE)	 )
					{
						System.out.printf("%s ��  %s ���!!\n"
								,players[0].getPlayerName(),players[0].getPokemons(i));
						p1Point++;
					}
				else//�ѤU �u�� P2 �|Ĺ�F
				{
					System.out.printf("%s ��  %s ���!!\n"
							,players[1].getPlayerName(),players[1].getPokemons(i));
					p2Point++;
				}
			}
			else if(  players[0].getPokemonsCP(i)
					!=players[1].getPokemonsCP(i)  )//CP ���@��
			{
				if( players[0].getPokemonsCP(i)>players[1].getPokemonsCP(i) )
				{
					System.out.printf("%s ��  %s ���!!\n"
							,players[0].getPlayerName(),players[0].getPokemons(i));
					p1Point++;
				}
				else
				{
					System.out.printf("%s ��  %s ���!!\n"
							,players[1].getPlayerName(),players[1].getPokemons(i));
					p2Point++;
				}
			}
			else// �g�L�W����ӱ���z�� ������o�ͫe����"�ݩʤ@��&&CP�@��"  
			{
				Random ran = new Random();
				int a = ran.nextInt(2)+1;
				
				    if(  (a%2) == 0 )
				    {
				    	System.out.printf("%s ��  %s ���!!\n"
								,players[0].getPlayerName(),players[0].getPokemons(i));
						p1Point++;
				    }
				    else
				    {
				    	System.out.printf("%s ��  %s ���!!\n"
								,players[1].getPlayerName(),players[1].getPokemons(i));
						p2Point++;
				    }
			}
			
		
		}
		if(  p1Point!=p2Point
		  && p1Point>p2Point)//P1 Ĺ
		{
			System.out.println("\""+players[0].getPlayerName()+"\""+"���!!");
			int L = players[0].getLevel();
			players[0].setLevel( L+1 ); //Level up
			System.out.printf("%s �ɯŦ� LV: %2d ��\n"
					,players[0].getPlayerName(),players[0].getLevel());
		}
		
		else
		{
			System.out.println("\""+players[1].getPlayerName()+"\""+"���!!");
			int L = players[1].getLevel();
			players[1].setLevel( L+1 );
			System.out.printf("%s �ɯŦ� LV: %2d ��\n"
					,players[1].getPlayerName(),players[1].getLevel());
		}
	
	}
}
