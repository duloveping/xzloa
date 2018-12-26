package cn.com.enjoystudy.oa.util;

import com.eaio.uuid.UUID;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerateUtils {
    public static String getRandomUUID(){
        return new UUID().toString();
    }

    public static String getTimeBasedUuid() {
        AtomicInteger count = new AtomicInteger(0);
        long time = System.currentTimeMillis() * 10000L + 122192928000000000L + (long)(count.incrementAndGet() % 10000);
        long timeLow = (time & 4294967295L) << 32;
        long timeMid = (time & 281470681743360L) >> 16;
        long timeHi = (time & 1152640029630136320L) >> 48;
        long most = timeLow | timeMid | 4096L | timeHi;
        UUID uuid = new UUID(most, 0L);
        return uuid.toString();
    }
}
