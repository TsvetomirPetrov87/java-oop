package CounterStriker.models.guns;

public class Pistol extends GunImpl implements Gun {
    private static final int BULLET_PISTOL = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if(super.getBulletsCount() < BULLET_PISTOL){
            return 0;
        }
        super.decreaseBullets(BULLET_PISTOL);
        return BULLET_PISTOL;
    }
}
