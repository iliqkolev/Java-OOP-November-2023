package magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bulletsCount = getBulletsCount();

        if (bulletsCount - 10 < 0) {
            setBulletsCount(0);
            return 0;
        }

        setBulletsCount(bulletsCount - 10);

        return 10;
    }
}
