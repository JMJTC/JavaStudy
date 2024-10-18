package algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem59 {
    public static void main(String[] args) {

    }
}

class Problem59_Solution{
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int l=0,r=n;
        int u=0,d=n;
        int xx=0,yy=0;
        for(int i=1;i<=n*n;){
            int ll=l,rr=r,uu=u,dd=d;
            //l->r
            while(++ll<rr){
                ans[xx][yy++]=i++;
            }
            //u->d
            while(++uu<dd){
                ans[xx++][yy]=i++;
            }
            //还原
            ll=l;rr=r;uu=u;dd=d;
            //r->l
            while(--rr>ll){
                ans[xx][yy--]=i++;
            }
            //d->u
            while(--dd>uu){
                ans[xx--][yy]=i++;
            }
            yy++;xx++;//注意要还原
            l++;r--;u++;d--;
            if(l>=r){
                break;
            }
        }
        if(n%2!=0){
            ans[n/2][n/2]=n*n;
        }
        return ans;
    }
}
