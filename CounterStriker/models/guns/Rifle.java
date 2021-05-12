package CounterStriker.models.guns;

public class Rifle extends GunImpl implements Gun {
    private static final int BULLET_RIFLE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if(super.getBulletsCount() < BULLET_RIFLE){
            return 0;
        }
        super.decreaseBullets(BULLET_RIFLE);
        return BULLET_RIFLE;
    }
}
