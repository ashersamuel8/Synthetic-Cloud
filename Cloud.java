import java.awt.Color;

public class Cloud{
  public static void fill (double x0, double y0, double x1, double y1, double var, double s){

    if (x1 - x0 < 0.01){
      // double delta = StdRandom.gaussian(0, Math.sqrt(var*100));
      double delta_R = StdRandom.gaussian(135, 20);
      double delta_G = StdRandom.gaussian(206, 20);
      double delta_B = StdRandom.gaussian(235, 20);

      // System.out.println(delta);
      // int R = (int) Math.round(135);
      // int G = (int) Math.round(206);
      // int B = (int) Math.round(235);
      int R = (int) Math.round(delta_R);
      int G = (int) Math.round(delta_G);
      int B = (int) Math.round(delta_B);
      System.out.println(R+","+G+","+B);
      // Color color = new Color(R, G, B);
      // StdDraw.setPenColor(color);
      // StdDraw.filledSquare(x0,y0, 0.01);
      return;
    }

    double xm = (x0 + x1) / 2;
    double ym = (y0 + y1) / 2;

    fill(x0, y0, xm, ym, var/s, s);
    fill(xm, ym, x1, y1, var/s, s);
    fill(x0, ym, xm, y1, var/s, s);
    fill(xm, y0, x1, ym, var/s, s);

  }

  public static void main(String[] args){
    double size = Double.parseDouble(args[0]);
    double hurst = 0.;
    double s = Math.pow(2, 2*hurst);
    fill(0, 0, 0 + size, 0 + size, 0.01, s);
  }
}
