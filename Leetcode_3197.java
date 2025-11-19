class Leetcode_3197{
    public static void main(String[] args) {
        int arr[][]={{1,0,1},{1,1,1}};
        System.out.print(minSum(arr));
    }
    public static int min_area(int arr[][],int cr,int cc,int er,int ec){
        int minr=Integer.MAX_VALUE;
        int maxr=Integer.MIN_VALUE;
        int minc=Integer.MAX_VALUE;
        int maxc=Integer.MIN_VALUE;
        for(int i=cr;i<=er;i++){
            for(int j=cc;j<=ec;j++){
                if(arr[i][j]==1){
                    minr=Math.min(minr,i);
                    maxr=Math.max(maxr,i);
                    minc=Math.min(minc,j);
                    maxc=Math.max(maxc,j);
                }
            }
        }
        return (maxr-minr+1)*(maxc-minc+1);
    }
    public static int minSum(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        int res=Integer.MAX_VALUE;
        //case- 1
        for(int i=0;i<n;i++){
            for(int j=i+1;j+1<n;j++){
                res=Math.min(res,min_area(arr,0,0,i,m-1)+min_area(arr,i+1,0,j,m-1)+min_area(arr,j+1,0,n-1,m-1));
            }
        }
       // case- 2
        for(int i=0;i<m;i++){
            for(int j=i+1;j+1<m;j++){
                res=Math.min(res,min_area(arr,0,0,n-1,i)+min_area(arr,0,i+1,n-1,j)+min_area(arr,0,j+1,n-1,m-1));
            }
        }
        //case- 3
        for(int i=0;i+1<n;i++){
            for(int j=0;j+1<m;j++){
                res=Math.min(res,min_area(arr,0,0,i,j)+min_area(arr,0,j+1,i,m-1)+min_area(arr,i+1,0,n-1,m-1));
            }
        }
        //case-4
        for(int i=0;i+1<n;i++){
            for(int j=0;j+1<m;j++){
                res=Math.min(res,min_area(arr,0,0,i,m-1)+min_area(arr,i+1,0,n-1,j)+min_area(arr,i+1,j+1,n-1,m-1));
            }
        }
        //case-5
         for(int i=0;i+1<n;i++){
            for(int j=0;j+1<m;j++){
                res=Math.min(res,min_area(arr,0,0,i,j)+min_area(arr,i+1,0,n-1,j)+min_area(arr,0,j+1,n-1,m-1));
            }
        }
        //case-6
         for(int i=0;i+1<n;i++){
            for(int j=0;j+1<m;j++){
               res=Math.min(res,min_area(arr,0,0,n-1,j)+min_area(arr,0,j+1,i,m-1)+min_area(arr,i+1,j+1,n-1,m-1));
            }
        }
        return res;
    }
}