package idv.wangyj.javaquartz2;

import idv.wangyj.javaquartz2.job.QuartJobUtil;

public class App2 {
    public static void main(String []args){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始》》》》》》》》》》》》》》");
        QuartJobUtil.startJob();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>结束》》》》》》》》》》》》》》");
    }
}
