package com.my.fitness.services;

import com.my.fitness.dto.AccountEntityDto;
import com.my.fitness.enums.SocialNetworkType;

/**
 * Account service interface
 */
public interface AccountService {

    /**
     * Get account by uuid
     * @param accountUUID Account uuid
     * @return Account
     */
    AccountEntityDto getAccountByUUID(String accountUUID);

    /**
     * Get or create an account
     * @param socialNetworkId Social network id
     * @param socialNetworkType Social network type
     * @param name Account name
     * @return Account
     */
    AccountEntityDto getOrCreateAccount(String socialNetworkId, SocialNetworkType socialNetworkType, String name);

}
