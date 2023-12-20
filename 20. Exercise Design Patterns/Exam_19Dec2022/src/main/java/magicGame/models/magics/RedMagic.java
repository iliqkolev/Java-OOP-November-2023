package magicGame.models.magics;

public class RedMagic extends MagicImpl {
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bulletsCount = getBulletsCount();

        if (bulletsCount - 1 < 0) {
            setBulletsCount(0);
            return 0;
        }

        setBulletsCount(bulletsCount - 1);

        return 1;
    }
}
