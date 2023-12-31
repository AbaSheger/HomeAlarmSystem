package submission;

public interface Detector {
    void trigger();
    void activate();
    void deactivate();
    boolean isActive();
    boolean detect();
    String getDetectorType();
    void reset();


}
