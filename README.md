# JPMorgan
Ejemplos para JPMorgan

README:
As a brief introduction to the design of the solution, intended for everybody to understand:
-Single JUnit file with @Test annotation methods for every enquery of the sheet.
-Enums for fixed types, like stock type or stock symbol.
-Singletons working as DB fashion - storing the stocks and the trades.
-SuperSimpleStockMarket holds all operations related to stocks.
-TradeStore implements trade recording.
