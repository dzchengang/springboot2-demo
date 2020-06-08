import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Redission {

	public static void main(String[] args) {
		Config config = new Config();
		config.useClusterServers().addNodeAddress("redis://172.16.10.38:7000", "redis://172.16.10.38:7001",
				"redis://172.16.10.38:7002", "redis://172.16.10.38:7003", "redis://172.16.10.38:7004",
				"redis://172.16.10.38:7005");
		config.useClusterServers().setPassword("qwe123-=");
		final RedissonClient redisson = Redisson.create(config);
	}

}
