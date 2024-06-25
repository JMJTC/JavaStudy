package Algorithm.lan.realquestion;

public class Clock {
    public static void main(String[] args) {
        //一分钟&一秒钟 6°
        for(int i=0;i<12;i++){
            //小时
            for(int j=0;j<60;j++){
                //分钟
                for(int k=0;k<60;k++){
                    //分钟
                    double mm =  k * 6;
                    double ff = 6 * (j + mm / 360);
                    double ss = 30 * (i + ff / 360);
                    double x = Math.abs(ff - ss);
                    double y = Math.abs(mm - ff);
                    if(x > 180) x = 360 - x;
                    if(y > 180) y = 360 - y;
                    if(x == 2 * y && (i+j+k)>0) {
                        System.out.println(i +" "+j+" "+k);
                    }
                }
            }
        }
        new Clock().showTime();
    }
    public void showTime(){

        System.out.println(System.currentTimeMillis());
    }
}


