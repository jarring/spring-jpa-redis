package privacy.hbltsl.repository;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import privacy.hbltsl.model.UserInfo;

@Repository
public class UserInfoRepository {

	// inject the actual template
	@Autowired
	private RedisTemplate<String, String> template; // inject the template as ListOperations

	@Resource(name = "redisTemplate")
	private HashOperations<UserInfo, Long, UserInfo> hashOperations;

	public void save(UserInfo ui) {
		hashOperations.put(ui, ui.getId(), ui);
	}

}
