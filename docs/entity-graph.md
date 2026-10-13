# Entity graph

This graph includes every table mapped by a JPA `@Entity` in `com.butler.app.entities` and every `@ManyToOne` association declared between those entities. Nodes use their mapped database table names. Arrows point from the referenced table to the table holding the foreign key; `1:N` describes that direction, and required/optional indicates whether the foreign key association is nullable.

```mermaid
flowchart LR
    account_providers["account_providers"]
    account_shares["account_shares"]
    account_statements["account_statements"]
    accounts["accounts"]
    active_storage_attachments["active_storage_attachments"]
    active_storage_blobs["active_storage_blobs"]
    active_storage_variant_records["active_storage_variant_records"]
    addresses["addresses"]
    akahu_accounts["akahu_accounts"]
    akahu_items["akahu_items"]
    api_keys["api_keys"]
    archived_exports["archived_exports"]
    balances["balances"]
    binance_accounts["binance_accounts"]
    binance_items["binance_items"]
    brex_accounts["brex_accounts"]
    brex_items["brex_items"]
    budget_categories["budget_categories"]
    budget_shares["budget_shares"]
    budgets["budgets"]
    categories["categories"]
    categorization_comparisons["categorization_comparisons"]
    chats["chats"]
    coinbase_accounts["coinbase_accounts"]
    coinbase_items["coinbase_items"]
    coinspot_accounts["coinspot_accounts"]
    coinspot_items["coinspot_items"]
    coinstats_accounts["coinstats_accounts"]
    coinstats_items["coinstats_items"]
    credit_cards["credit_cards"]
    cryptos["cryptos"]
    data_enrichments["data_enrichments"]
    debug_log_entries["debug_log_entries"]
    depositories["depositories"]
    enable_banking_accounts["enable_banking_accounts"]
    enable_banking_items["enable_banking_items"]
    entries["entries"]
    eval_datasets["eval_datasets"]
    eval_results["eval_results"]
    eval_runs["eval_runs"]
    eval_samples["eval_samples"]
    exchange_rate_pairs["exchange_rate_pairs"]
    exchange_rates["exchange_rates"]
    families["families"]
    family_documents["family_documents"]
    family_exports["family_exports"]
    family_merchant_associations["family_merchant_associations"]
    financekit_account_lineages["financekit_account_lineages"]
    financekit_accounts["financekit_accounts"]
    financekit_balance_observations["financekit_balance_observations"]
    financekit_batches["financekit_batches"]
    financekit_conflicts["financekit_conflicts"]
    financekit_items["financekit_items"]
    financekit_transactions["financekit_transactions"]
    fio_accounts["fio_accounts"]
    fio_items["fio_items"]
    goal_accounts["goal_accounts"]
    goal_pledges["goal_pledges"]
    goals["goals"]
    holdings["holdings"]
    ibkr_accounts["ibkr_accounts"]
    ibkr_items["ibkr_items"]
    impersonation_session_logs["impersonation_session_logs"]
    impersonation_sessions["impersonation_sessions"]
    import_mappings["import_mappings"]
    import_rows["import_rows"]
    import_sessions["import_sessions"]
    import_source_mappings["import_source_mappings"]
    imports["imports"]
    indexa_capital_accounts["indexa_capital_accounts"]
    indexa_capital_items["indexa_capital_items"]
    insights["insights"]
    investments["investments"]
    invitations["invitations"]
    invite_codes["invite_codes"]
    kraken_accounts["kraken_accounts"]
    kraken_items["kraken_items"]
    llm_usages["llm_usages"]
    loans["loans"]
    lunchflow_accounts["lunchflow_accounts"]
    lunchflow_items["lunchflow_items"]
    merchants["merchants"]
    mercury_accounts["mercury_accounts"]
    mercury_items["mercury_items"]
    messages["messages"]
    mobile_devices["mobile_devices"]
    monobank_accounts["monobank_accounts"]
    monobank_items["monobank_items"]
    notification_deliveries["notification_deliveries"]
    oauth_access_grants["oauth_access_grants"]
    oauth_access_tokens["oauth_access_tokens"]
    oauth_applications["oauth_applications"]
    oidc_identities["oidc_identities"]
    onchain_wallet_accounts["onchain_wallet_accounts"]
    onchain_wallet_items["onchain_wallet_items"]
    other_assets["other_assets"]
    other_liabilities["other_liabilities"]
    plaid_accounts["plaid_accounts"]
    plaid_items["plaid_items"]
    properties["properties"]
    provider_request_counts["provider_request_counts"]
    push_subscriptions["push_subscriptions"]
    questrade_accounts["questrade_accounts"]
    questrade_items["questrade_items"]
    recurrence_rules["recurrence_rules"]
    recurring_allocations["recurring_allocations"]
    recurring_match_rejections["recurring_match_rejections"]
    recurring_occurrences["recurring_occurrences"]
    recurring_price_changes["recurring_price_changes"]
    recurring_transactions["recurring_transactions"]
    redbark_accounts["redbark_accounts"]
    redbark_items["redbark_items"]
    rejected_transfers["rejected_transfers"]
    rule_actions["rule_actions"]
    rule_conditions["rule_conditions"]
    rule_runs["rule_runs"]
    rules["rules"]
    securities["securities"]
    security_prices["security_prices"]
    security_splits["security_splits"]
    sessions["sessions"]
    settings["settings"]
    simplefin_accounts["simplefin_accounts"]
    simplefin_items["simplefin_items"]
    snaptrade_accounts["snaptrade_accounts"]
    snaptrade_items["snaptrade_items"]
    sophtron_accounts["sophtron_accounts"]
    sophtron_items["sophtron_items"]
    sso_audit_logs["sso_audit_logs"]
    sso_identity_blocks["sso_identity_blocks"]
    sso_providers["sso_providers"]
    subscriptions["subscriptions"]
    syncs["syncs"]
    taggings["taggings"]
    tags["tags"]
    tool_calls["tool_calls"]
    trade_republic_accounts["trade_republic_accounts"]
    trade_republic_items["trade_republic_items"]
    trades["trades"]
    trading212_accounts["trading212_accounts"]
    trading212_items["trading212_items"]
    transactions["transactions"]
    transfers["transfers"]
    up_accounts["up_accounts"]
    up_items["up_items"]
    users["users"]
    valuations["valuations"]
    vehicles["vehicles"]
    webauthn_credentials["webauthn_credentials"]
    wise_accounts["wise_accounts"]
    wise_items["wise_items"]
    account_providers -->|"accountProvider: 1:N, optional"| debug_log_entries
    account_providers -->|"accountProvider: 1:N, optional"| holdings
    account_statements -->|"reconciledByStatement: 1:N, optional"| entries
    account_statements -->|"accountStatement: 1:N, optional"| imports
    accounts -->|"account: 1:N, required"| account_providers
    accounts -->|"account: 1:N, required"| account_shares
    accounts -->|"account: 1:N, optional"| account_statements
    accounts -->|"suggestedAccount: 1:N, optional"| account_statements
    accounts -->|"account: 1:N, required"| balances
    accounts -->|"account: 1:N, optional"| debug_log_entries
    accounts -->|"account: 1:N, required"| entries
    accounts -->|"account: 1:N, optional"| financekit_account_lineages
    accounts -->|"account: 1:N, required"| goal_accounts
    accounts -->|"account: 1:N, required"| goal_pledges
    accounts -->|"account: 1:N, required"| holdings
    accounts -->|"account: 1:N, optional"| recurring_transactions
    accounts -->|"destinationAccount: 1:N, optional"| recurring_transactions
    accounts -->|"defaultAccount: 1:N, optional"| users
    active_storage_blobs -->|"blob: 1:N, required"| active_storage_attachments
    active_storage_blobs -->|"blob: 1:N, required"| active_storage_variant_records
    akahu_items -->|"akahuItem: 1:N, required"| akahu_accounts
    binance_items -->|"binanceItem: 1:N, required"| binance_accounts
    brex_items -->|"brexItem: 1:N, required"| brex_accounts
    budgets -->|"budget: 1:N, required"| budget_categories
    categories -->|"category: 1:N, required"| budget_categories
    categories -->|"category: 1:N, optional"| recurring_transactions
    categories -->|"category: 1:N, optional"| transactions
    chats -->|"chat: 1:N, required"| messages
    chats -->|"lastViewedChat: 1:N, optional"| users
    coinbase_items -->|"coinbaseItem: 1:N, required"| coinbase_accounts
    coinspot_items -->|"coinspotItem: 1:N, required"| coinspot_accounts
    coinstats_items -->|"coinstatsItem: 1:N, required"| coinstats_accounts
    enable_banking_items -->|"enableBankingItem: 1:N, required"| enable_banking_accounts
    entries -->|"parentEntry: 1:N, optional"| entries
    entries -->|"entry: 1:N, optional"| financekit_transactions
    entries -->|"entry: 1:N, optional"| recurring_allocations
    entries -->|"entry: 1:N, required"| recurring_match_rejections
    entries -->|"entry: 1:N, optional"| recurring_price_changes
    eval_datasets -->|"evalDataset: 1:N, required"| eval_runs
    eval_datasets -->|"evalDataset: 1:N, required"| eval_samples
    eval_runs -->|"evalRun: 1:N, required"| eval_results
    eval_samples -->|"evalSample: 1:N, required"| eval_results
    families -->|"family: 1:N, required"| account_statements
    families -->|"family: 1:N, required"| accounts
    families -->|"family: 1:N, required"| akahu_items
    families -->|"family: 1:N, required"| binance_items
    families -->|"family: 1:N, required"| brex_items
    families -->|"family: 1:N, required"| budgets
    families -->|"family: 1:N, required"| categories
    families -->|"family: 1:N, required"| categorization_comparisons
    families -->|"family: 1:N, required"| coinbase_items
    families -->|"family: 1:N, required"| coinspot_items
    families -->|"family: 1:N, required"| coinstats_items
    families -->|"family: 1:N, optional"| debug_log_entries
    families -->|"family: 1:N, required"| enable_banking_items
    families -->|"family: 1:N, required"| family_documents
    families -->|"family: 1:N, required"| family_exports
    families -->|"family: 1:N, required"| family_merchant_associations
    families -->|"family: 1:N, required"| financekit_account_lineages
    families -->|"family: 1:N, required"| financekit_conflicts
    families -->|"family: 1:N, required"| financekit_items
    families -->|"family: 1:N, required"| fio_items
    families -->|"family: 1:N, required"| goals
    families -->|"family: 1:N, required"| ibkr_items
    families -->|"family: 1:N, required"| import_sessions
    families -->|"family: 1:N, required"| import_source_mappings
    families -->|"family: 1:N, required"| imports
    families -->|"family: 1:N, required"| indexa_capital_items
    families -->|"family: 1:N, required"| insights
    families -->|"family: 1:N, required"| invitations
    families -->|"family: 1:N, required"| kraken_items
    families -->|"family: 1:N, required"| llm_usages
    families -->|"family: 1:N, required"| lunchflow_items
    families -->|"family: 1:N, optional"| merchants
    families -->|"family: 1:N, required"| mercury_items
    families -->|"family: 1:N, required"| monobank_items
    families -->|"family: 1:N, required"| onchain_wallet_items
    families -->|"family: 1:N, required"| plaid_items
    families -->|"family: 1:N, required"| questrade_items
    families -->|"family: 1:N, required"| recurring_occurrences
    families -->|"family: 1:N, required"| recurring_transactions
    families -->|"family: 1:N, required"| redbark_items
    families -->|"family: 1:N, required"| rules
    families -->|"family: 1:N, required"| simplefin_items
    families -->|"family: 1:N, required"| snaptrade_items
    families -->|"family: 1:N, required"| sophtron_items
    families -->|"family: 1:N, required"| subscriptions
    families -->|"family: 1:N, required"| tags
    families -->|"family: 1:N, required"| trade_republic_items
    families -->|"family: 1:N, required"| trading212_items
    families -->|"family: 1:N, required"| up_items
    families -->|"family: 1:N, required"| users
    families -->|"family: 1:N, required"| wise_items
    financekit_account_lineages -->|"financekitAccountLineage: 1:N, required"| financekit_accounts
    financekit_account_lineages -->|"financekitAccountLineage: 1:N, required"| financekit_balance_observations
    financekit_account_lineages -->|"financekitAccountLineage: 1:N, optional"| financekit_conflicts
    financekit_account_lineages -->|"financekitAccountLineage: 1:N, required"| financekit_transactions
    financekit_accounts -->|"financekitAccount: 1:N, optional"| financekit_balance_observations
    financekit_accounts -->|"financekitAccount: 1:N, optional"| financekit_transactions
    financekit_items -->|"financekitItem: 1:N, required"| financekit_accounts
    financekit_items -->|"financekitItem: 1:N, required"| financekit_batches
    financekit_items -->|"financekitItem: 1:N, required"| financekit_conflicts
    financekit_items -->|"replacesFinancekitItem: 1:N, optional"| financekit_items
    financekit_transactions -->|"financekitTransaction: 1:N, optional"| financekit_conflicts
    fio_items -->|"fioItem: 1:N, required"| fio_accounts
    goals -->|"goal: 1:N, required"| goal_accounts
    goals -->|"goal: 1:N, required"| goal_pledges
    ibkr_items -->|"ibkrItem: 1:N, required"| ibkr_accounts
    impersonation_sessions -->|"impersonationSession: 1:N, required"| impersonation_session_logs
    impersonation_sessions -->|"activeImpersonatorSession: 1:N, optional"| sessions
    import_sessions -->|"importSession: 1:N, required"| import_source_mappings
    import_sessions -->|"importSession: 1:N, optional"| imports
    imports -->|"importValue: 1:N, optional"| accounts
    imports -->|"importValue: 1:N, optional"| entries
    imports -->|"importValue: 1:N, required"| import_rows
    indexa_capital_items -->|"indexaCapitalItem: 1:N, required"| indexa_capital_accounts
    kraken_items -->|"krakenItem: 1:N, required"| kraken_accounts
    lunchflow_items -->|"lunchflowItem: 1:N, required"| lunchflow_accounts
    merchants -->|"merchant: 1:N, required"| family_merchant_associations
    merchants -->|"merchant: 1:N, optional"| recurring_transactions
    merchants -->|"merchant: 1:N, optional"| transactions
    mercury_items -->|"mercuryItem: 1:N, required"| mercury_accounts
    messages -->|"message: 1:N, required"| tool_calls
    monobank_items -->|"monobankItem: 1:N, required"| monobank_accounts
    oauth_applications -->|"application: 1:N, required"| oauth_access_grants
    oauth_applications -->|"application: 1:N, required"| oauth_access_tokens
    onchain_wallet_items -->|"onchainWalletItem: 1:N, required"| onchain_wallet_accounts
    plaid_accounts -->|"plaidAccount: 1:N, optional"| accounts
    plaid_items -->|"plaidItem: 1:N, required"| plaid_accounts
    questrade_items -->|"questradeItem: 1:N, required"| questrade_accounts
    recurring_occurrences -->|"recurringOccurrence: 1:N, required"| recurring_allocations
    recurring_transactions -->|"recurringTransaction: 1:N, required"| recurrence_rules
    recurring_transactions -->|"recurringTransaction: 1:N, required"| recurring_match_rejections
    recurring_transactions -->|"recurringTransaction: 1:N, required"| recurring_occurrences
    recurring_transactions -->|"recurringTransaction: 1:N, required"| recurring_price_changes
    recurring_transactions -->|"replacedBy: 1:N, optional"| recurring_transactions
    redbark_items -->|"redbarkItem: 1:N, required"| redbark_accounts
    rule_conditions -->|"parent: 1:N, optional"| rule_conditions
    rules -->|"rule: 1:N, required"| notification_deliveries
    rules -->|"rule: 1:N, required"| rule_actions
    rules -->|"rule: 1:N, optional"| rule_conditions
    rules -->|"rule: 1:N, required"| rule_runs
    securities -->|"providerSecurity: 1:N, optional"| holdings
    securities -->|"security: 1:N, required"| holdings
    securities -->|"security: 1:N, optional"| security_prices
    securities -->|"security: 1:N, required"| security_splits
    securities -->|"security: 1:N, required"| trades
    simplefin_accounts -->|"simplefinAccount: 1:N, optional"| accounts
    simplefin_items -->|"simplefinItem: 1:N, required"| simplefin_accounts
    snaptrade_items -->|"snaptradeItem: 1:N, required"| snaptrade_accounts
    sophtron_items -->|"sophtronItem: 1:N, required"| sophtron_accounts
    syncs -->|"sync: 1:N, optional"| financekit_batches
    syncs -->|"parent: 1:N, optional"| syncs
    tags -->|"tag: 1:N, required"| taggings
    trade_republic_items -->|"tradeRepublicItem: 1:N, required"| trade_republic_accounts
    trading212_items -->|"trading212Item: 1:N, required"| trading212_accounts
    transactions -->|"transaction: 1:N, optional"| categorization_comparisons
    transactions -->|"matchedTransaction: 1:N, optional"| goal_pledges
    transactions -->|"transaction: 1:N, required"| notification_deliveries
    transactions -->|"inflowTransaction: 1:N, required"| rejected_transfers
    transactions -->|"outflowTransaction: 1:N, required"| rejected_transfers
    transactions -->|"inflowTransaction: 1:N, required"| transfers
    transactions -->|"outflowTransaction: 1:N, required"| transfers
    transfers -->|"transfer: 1:N, optional"| transactions
    up_items -->|"upItem: 1:N, required"| up_accounts
    users -->|"user: 1:N, required"| account_shares
    users -->|"owner: 1:N, optional"| accounts
    users -->|"user: 1:N, required"| api_keys
    users -->|"owner: 1:N, required"| budget_shares
    users -->|"viewer: 1:N, required"| budget_shares
    users -->|"user: 1:N, optional"| budgets
    users -->|"user: 1:N, required"| chats
    users -->|"user: 1:N, optional"| debug_log_entries
    users -->|"resolvedBy: 1:N, optional"| financekit_conflicts
    users -->|"user: 1:N, required"| financekit_items
    users -->|"impersonated: 1:N, required"| impersonation_sessions
    users -->|"impersonator: 1:N, required"| impersonation_sessions
    users -->|"inviter: 1:N, required"| invitations
    users -->|"user: 1:N, required"| mobile_devices
    users -->|"user: 1:N, required"| oidc_identities
    users -->|"owner: 1:N, optional"| plaid_items
    users -->|"user: 1:N, required"| push_subscriptions
    users -->|"user: 1:N, required"| sessions
    users -->|"user: 1:N, optional"| sso_audit_logs
    users -->|"user: 1:N, required"| webauthn_credentials
    wise_items -->|"wiseItem: 1:N, required"| wise_accounts
```

Polymorphic references stored as scalar type/id columns (for example `accounts.accountable_type` and `accounts.accountable_id`) are not declared JPA associations and therefore are not shown as typed edges.
