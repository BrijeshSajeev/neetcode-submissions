class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         // Create array of pairs (position, time)
        double[][] cars = new double[position.length][2];
        
        for (int i = 0; i < position.length; i++) {
            double time = (double)(target - position[i]) / speed[i];
            cars[i][0] = position[i];
            cars[i][1] = time;
        }
        
        // Sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        double maxTime = 0.0;
        int fleet = 0;
        
        for (double[] car : cars) {
            double time = car[1];
            if (time > maxTime) {
                fleet++;
                maxTime = time;
            }
        }
        
        return fleet;
    }
}
