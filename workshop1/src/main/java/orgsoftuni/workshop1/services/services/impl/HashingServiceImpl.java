package orgsoftuni.workshop1.services.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import orgsoftuni.workshop1.services.services.HashingService;

@Service
public class HashingServiceImpl implements HashingService {
    @Override
    public String hashPass(String username, String password) {
        String hashingString = username.toUpperCase() + ":" + password.toUpperCase();
        return DigestUtils.sha1Hex(hashingString);
    }
}
