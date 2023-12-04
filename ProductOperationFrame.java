import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class ProductOperationFrame extends JFrame {

    public ProductOperationFrame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                onFrameClosed();
            }
        });
        initialize();
    }

    protected abstract void initialize();

    protected abstract void onFrameClosed();
}

