package pkg202007;

public class M05_07 {

    public int exchangeBits(final int num) {
        final int odd = num & 0x55555555;
        final int even = num & 0xaaaaaaaa;
        return (odd << 1 & even >>> 1);
    }
}
