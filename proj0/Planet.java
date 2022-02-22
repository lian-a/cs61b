public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV,double m,String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;

    }

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p){
        double g = 6.67e-11;
        return g * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p){
        double f = this.calcForceExertedBy(p);
        return f * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        double f = this.calcForceExertedBy(p);
        return f * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] Pla_arr) {
        double sum = 0;
        for(Planet p : Pla_arr){
            if(!this.equals(p))
                sum += this.calcForceExertedByX(p);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] Pla_arr) {
        double sum = 0;
        for(Planet p : Pla_arr) {
            if(!this.equals(p))
                sum += this.calcForceExertedByY(p);
        }
        return sum;
    }

    public void update(double t, double fx, double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + ax * t;
        this.yyVel = this.yyVel + ay * t;
        this.xxPos += t * this.xxVel;
        this.yyPos += t * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos,yyPos,"images/" + imgFileName);
    }
}
