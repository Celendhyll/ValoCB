package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.ClientDTO;
import java.math.BigDecimal;

/**
 * Interface used to handle operations related to Client.
 */
public interface IClientService {

    /**
     * Calculates the capital of a client according to a currency.
     * @param client - the wanted client
     * @param currency - the wanted currency
     * @return the capital of the wanted client in the wanted currency
     * @throws RuntimeException - in case of an error with the calculus
     */
    BigDecimal getClientCapital(ClientDTO client, String currency) throws RuntimeException;
}
