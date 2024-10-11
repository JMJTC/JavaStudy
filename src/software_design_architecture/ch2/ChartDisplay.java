package software_design_architecture.ch2;

/**
 * @author jmjtc
 */
public class ChartDisplay {
    private AbstractChart chart;

    public void display() {
        if (chart != null) {
            chart.display();
        }
    }

    public AbstractChart getChart() {
        return chart;
    }

    public void setChart(AbstractChart chart) {
        this.chart = chart;
    }
}
