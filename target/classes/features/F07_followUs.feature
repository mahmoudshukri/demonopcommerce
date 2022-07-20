@smoke
    Feature: F07|Follow Us Feature

    Scenario Outline: User want to open follow us links
      When User clicks on <socialMedia> link
      Then <Url> is opened in new tab
      Examples:
        | socialMedia|Url|
        | facebook|https://www.facebook.com/nopCommerce|
        | twitter|https://twitter.com/nopCommerce|
        | rss|https://demo.nopcommerce.com/new-online-store-is-open|
        | youtube|https://www.youtube.com/user/nopCommerce|