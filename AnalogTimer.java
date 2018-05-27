import java.util.Date;

public class AnalogTimer extends Thread{
    public static void main (String[] args) throws InterruptedException  {
        //변수
        int size = 20; //시계 사이즈 설정
        AnalogT Timer = new AnalogT(size);

        Date time;
        double h;
        double m;
        double s;

        double hr;
        double mr;
        double sr;

        //시계 실행
        while (true) {
            //시계 좌표 초기화
            Timer.xyreset();
            //현재 시간 받아오기
            time = new Date();
            h = time.getHours();
            if (h > 12d) h = h-12d;
            m = time.getMinutes();
            s = time.getSeconds();

            hr = (h/12*360+90)*Math.PI/180;
            mr = (m/60*360+90)*Math.PI/180;
            sr = (s/60*360+90)*Math.PI/180;

            for (int lp = 0; lp < 12; lp++) {
                Timer.coord[(int) (size/2-Math.floor(Math.sin(hr)*size/40*lp))][(int) (size/2-Math.floor(Math.cos(hr)*size/40*lp))] = true;
            }
            for (int lp = 0; lp < 8; lp++) {
                Timer.coord[(int) (size/2-Math.floor(Math.sin(mr)*size/40*lp))][(int) (size/2-Math.floor(Math.cos(mr)*size/40*lp))] = true;
            }
            for (int lp = 0; lp < 4; lp++) {
                Timer.coord[(int) (size/2-Math.floor(Math.sin(sr)*size/40*lp))][(int) (size/2-Math.floor(Math.cos(sr)*size/40*lp))] = true;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            Timer.xyview();
            System.out.print("아날로그 시계 \n     현재 시간 :"+(int) h+"시 "+(int) m+"분 "+(int) s+"초 made by \" M0NGK1 \" ");
            sleep(1000);
        }



    }
}
class AnalogT {
    static int size;

    static public boolean[][] coord = new boolean[size][size];
    public AnalogT(int s) {
        size = s;
        coord = new boolean[size][size];
        xyreset();
    }

    public static void xyset(int Xv, int Yv) {
        coord[Yv][Xv] = true;
    }
    public static void xyview() {
        for (int lp = 0; lp < size ; lp ++) {
            for (int lp2 = 0; lp2 < size ; lp2++) {
                if (coord[lp][lp2] == true) System.out.print("■ ");
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
    public static void xyreset() {
        for (int lp = 0; lp < size ; lp ++) {
            for (int lp2 = 0; lp2 < size ; lp2++) {
                coord[lp][lp2] = false;
            }
        }
        for (int lp = 0; lp < 360; lp++)
            coord[(int) (size/2+Math.floor(Math.cos(lp*Math.PI/180)*size/20*8))][(int) (size/2+Math.floor(Math.sin(lp*Math.PI/180)*size/20*8))] = true;
    }
}