public class Spring{

    public double k; 

    public Spring(){
        this.k = 1;
    }

    public Spring(double k){
        this.k = k;
    }

    public double getK(){
        return k;
    }

    private void setK(double k){
        this.k = k;
    }

    public double[] move(double t, double dt, double x0, double v0){
        double m = 1;
        double w = Math.sqrt(k/m);
        double t0 = 0;
        double[] xt = new double[(int)Math.ceil((t- t0)/dt)];
        
        for(int i = 0, j = 0; i <= t; i+=dt, j++ ){
            double val = x0* Math.cos(w*i) + (v0/w) * Math.sin(w*i);
            xt[j]=val;
        }
        return xt;
    }

    public double[] move(double t, double dt, double x0){
        double m = 1;
        double w = Math.sqrt(k/m);
        double t0 = 0;
        double v0 = 0;
        double[] xt = new double[(int)Math.ceil((t- t0)/dt)];
        
        for(int j = 0; t0 <= t; t0+=dt, j++ ){
            double val = x0* Math.cos(w*t0) + (v0/w) * Math.sin(w*t0);
            xt[j]=val;
        }
        return xt;
    }
    public double[] move(double t0, double t1, double dt, double x0, double v0){
        double m = 1;
        double w = Math.sqrt(k/m);
        double[] xt = new double[(int)Math.ceil((t1 - t0)/dt)];
        
        for(int j = 0; t0 <= t1; t0+=dt, j++ ){
            double val = x0* Math.cos(w*t0) + (v0/w) * Math.sin(w*t0);
            xt[j]=val;
        }
        return xt;
    }
    public double[] move(double t0, double t1, double dt, double x0, double v0, double m){
        double w = Math.sqrt(k/m);
        double[] xt = new double[(int)Math.ceil((t1 - t0)/dt)];
        
        for(int j = 0; t0 <= t1; t0+=dt, j++ ){
            double val = x0* Math.cos(w*t0) + (v0/w) * Math.sin(w*t0);
            xt[j]=val;
        }
        return xt;
    }

    public Spring inSeries(Spring that){
        double k1 = that.getK();
        double keff = (k1 * k)/ (k1+k);

        return new Spring(keff);
    }

    public Spring inParallel(Spring that){
        double k1 = that.getK();
        double keff = k1 + k;

        return new Spring(keff);
    }
    public static void main(String[] args){

    }
}