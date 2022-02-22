public class NBody {

    public static double readRadius(String path){
        In in = new In(path);
        int num = in.readInt();
        double Radius = in.readDouble();
        return Radius;
    }

    public static Planet[] readPlanets(String filename) {
        int i = 0;
        In in = new In(filename);
        int num = in.readInt();
        double Radius = in.readDouble();
        Planet[] Pla_arr = new Planet[num];
        while(i < num) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Pla_arr[i] = new Planet(xP,yP,xV,yV,m,img);
            i += 1;
        }
        return Pla_arr;
    }

    public static void main(String[] args) {
        
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        In in = new In(filename);
        int num = in.readInt();
        double Radius = in.readDouble();
        Planet[] Pla_arr = NBody.readPlanets(filename);

        StdDraw.setScale(-Radius,Radius);
        StdDraw.enableDoubleBuffering();

        for(int time = 0; time < T; time = time + 1) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for(int i = 0; i < num; i += 1) {
                xForces[i] = Pla_arr[i].calcNetForceExertedByX(Pla_arr);
                yForces[i] = Pla_arr[i].calcNetForceExertedByY(Pla_arr);
            }

            for(int i = 0; i < num; i++) {
                Pla_arr[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0,0,"images/starfield.jpg");

            for (Planet planet : Pla_arr) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", Pla_arr.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < Pla_arr.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          Pla_arr[i].xxPos, Pla_arr[i].yyPos, Pla_arr[i].xxVel,
                          Pla_arr[i].yyVel, Pla_arr[i].mass, Pla_arr[i].imgFileName);
        }
    }
}
