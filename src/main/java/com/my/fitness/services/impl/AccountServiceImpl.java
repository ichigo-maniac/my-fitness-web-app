package com.my.fitness.services.impl;

import com.my.fitness.dto.AccountEntityDto;
import com.my.fitness.enums.SocialNetworkType;
import com.my.fitness.services.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Account service
 */
@Service("accountService")
public class AccountServiceImpl extends AbstractRestService implements AccountService {

    /**
     * Get or create an account
     * @param socialNetworkId Social network id
     * @param socialNetworkType Social network type
     * @param name Account name
     * @return Account
     */
    @Override
    public AccountEntityDto getOrCreateAccount(String socialNetworkId, SocialNetworkType socialNetworkType, String name) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("socialNetworkId", socialNetworkId);
        params.add("socialNetworkType", socialNetworkType.getValue());
        params.add("name", name);
        return postForObject("/account/get_or_create_account", params, AccountEntityDto.class);
    }
}
