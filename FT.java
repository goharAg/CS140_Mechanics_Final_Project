public class FT {
    double period , delta ; double omega0;
    int N;
    double[] coord;
    
    FT(double[] coord, int N, double delta) { 
        this.coord = coord;
        this.delta = delta ;
        this.N = N;
        period = N*delta;
        omega0 = 2*Math.PI/period;
    }

    double getSineCoefficient ( int n) { 
        double sum = 0;
        double t = 0;
        for(int i = 0;i<N;i++) {
            sum += coord[i]*Math.sin(n*omega0*t);
            t += delta;
        }
        return 2*delta*sum/period;
    }

    double getCosineCoefficient ( int n) { 
        double sum = 0;
        double t = 0;
        for(int i = 0;i<N;i++) {
            sum += coord[i]*Math.cos(n*omega0*t);
            t += delta;
        }
        return 2 * delta * (sum/period); 
    }

}
