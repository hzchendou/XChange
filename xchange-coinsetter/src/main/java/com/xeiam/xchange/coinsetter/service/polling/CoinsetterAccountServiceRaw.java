package com.xeiam.xchange.coinsetter.service.polling;

import java.io.IOException;
import java.util.UUID;

import si.mazi.rescu.RestProxyFactory;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.coinsetter.CoinsetterException;
import com.xeiam.xchange.coinsetter.dto.account.CoinsetterAccount;
import com.xeiam.xchange.coinsetter.dto.account.CoinsetterAccountList;
import com.xeiam.xchange.service.BaseExchangeService;

public class CoinsetterAccountServiceRaw extends BaseExchangeService {

  private final com.xeiam.xchange.coinsetter.rs.CoinsetterAccount account;

  /**
   * @param exchangeSpecification
   */
  public CoinsetterAccountServiceRaw(ExchangeSpecification exchangeSpecification) {

    super(exchangeSpecification);
    String baseUrl = exchangeSpecification.getSslUri();
    account = RestProxyFactory.createProxy(com.xeiam.xchange.coinsetter.rs.CoinsetterAccount.class, baseUrl);
  }

  public CoinsetterAccount get(UUID clientSessionId, UUID accountUuid) throws CoinsetterException, IOException {

    return account.get(clientSessionId, accountUuid);
  }

  public CoinsetterAccountList list(UUID clientSessionId) throws CoinsetterException, IOException {

    return account.list(clientSessionId);
  }

}
