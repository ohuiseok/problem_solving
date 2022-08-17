import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//y,x
	static List<int []> cctvAll = new ArrayList<int []>(); 
	static final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static final int[][] cctvType1 = {{0},{1},{2},{3}};
	static final int[][] cctvType2 = {{0,2},{1,3}};
	static final int[][] cctvType3 = {{0,1},{1,2},{2,3},{3,0}};
	static final int[][] cctvType4 = {{0,1,2},{1,2,3},{2,3,0},{3,0,1}};
	static final int[][] cctvType5 = {{0,1,2,3}};
	static int minValue = Integer.MAX_VALUE;
	static int N,M;
	
	public static void print(char[][] area) {

		for(int i=0;i<area.length;i++) {
			for(int j=0;j<area[0].length;j++) {
				System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void areaSetting(char[][] area,int index) {
		if(index==cctvAll.size()) {
//			print(area);
			int point = 0;
			for(int i=0;i<area.length;i++)
				for(int j=0;j<area[0].length;j++)
					if(area[i][j]=='0') {
						point++;
					}
//			System.out.println("point : "+point);
			if( minValue>point)
				minValue=point;

//			System.out.println();
			return;
		}
		
		int[][] cctyType = type2cctvType(cctvAll.get(index)[2]);
		
		for(int i =0;i<cctyType.length;i++) { //cctv   회전 수 ? 
			char[][] newArea= copyArray(area);
			newArea=shapSetting(newArea,i,cctvAll.get(index)[2],cctvAll.get(index)[0],cctvAll.get(index)[1]);
			areaSetting(newArea,index+1);
				
		}
		
	}
	
	public static char[][] shapSetting(char[][] area,int order, int type,int startR,int startC){
		int[][] cctyType = type2cctvType(type);
		
		for(int i=0;i<cctyType[0].length;i++) {
			int tmpDir = cctyType[order][i];
			area=moveGo(area,startR,startC,tmpDir);
		}
		
		return area;
		
	}
	
	public static char[][] moveGo(char[][] area,int startR,int startC,int tmpDir){

		while(true) {
			startR+=dir[tmpDir][0];
			startC+=dir[tmpDir][1];
			if(startR<0 || startC<0 ||startR>=N || startC>=M || area[startR][startC]=='6'  )
				break;
			area[startR][startC]='#';
		}
		
		return area;
	}
	
	public static int[][] type2cctvType(int type){
		switch(type) {
		case 1:
			return cctvType1;
		case 2:
			return cctvType2;
		case 3:
			return cctvType3;
		case 4:
			return cctvType4;
		case 5:
		default :
			return cctvType5;
		}
	}
	
	public static char[][] copyArray(char[][] area){
		char[][] newArea = new char[area.length][area[0].length];
		for(int i=0;i<area.length;i++) {
			for(int j=0;j<area[0].length;j++)
				newArea[i][j]=area[i][j];
		}
		return newArea;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] area = new char[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				area[i][j] = st.nextToken().charAt(0);
				if(area[i][j]!='0' && area[i][j]!='6') {
					cctvAll.add(new int[] {i,j,area[i][j]-'0'});
				}
			}
		}
		
//		for(int[] a : cctvAll) {
//			System.out.println("cctv : "+Arrays.toString(a));
//		}
		areaSetting(area,0);
		System.out.println(minValue);
	}
	
	/*
	 * 



	 * */
}
