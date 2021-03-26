package com.qa.practice;

public class Pattern {

	//1. right angled triangle
	static void rightTriangle(int n)
	{
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 2. inverted right triangle
	static void invertedRightTriangle(int n)
	{
		for(int i=0;i<=n;i++)
		{
			for(int j=n-i;j>=0;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 3. Left triangle
	static void leftTriangle(int n)
	{
		for(int i=0;i<=n;i++)
		{
			for(int j=n-1;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 4. inverted Left triangle
		static void invertedleftTriangle(int n)
		{
			for(int i=0;i<=n;i++)
			{
				for(int k=0;k<=n-i;k++)
				{
					System.out.print("*");
				}
				for(int j=n-1;j>=i;j--)
				{
					System.out.print(" ");
				}
				
				System.out.println();
			}
		}
		
	//5.pyramid 
		static void pyramid(int n)
		{
			for(int i=0;i<=n;i++)
			{
				for(int j=n-1;j>=i;j--)
				{
					System.out.print(" ");
				}
				for(int k=0;k<=i;k++)
				{
					System.out.print("*");
				}
				for(int l=1;l<=i;l++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		}
		

		//6.Inverted pyramid 
			static void invertedpyramid(int n)
			{
				for(int i=0;i<=n;i++)
				{
					for(int j=0;j<=i;j++)
					{
						System.out.print(" ");
					}
					for(int k=n;k>=i;k--)
					{
						System.out.print("*");
					}
					for(int l=n-1;l>=i;l--)
					{
						System.out.print("*");
					}
					System.out.println();
				}
			}
			
			
	public static void main(String[] args) {
		//rightTriangle(5);
		//invertedRightTriangle(5);
		//leftTriangle(5);
		//invertedleftTriangle(5);
		//pyramid(5);
		invertedpyramid(5);
	}

}
