package com.example.remontada.data

import com.example.remontada.domains.Position
import com.example.remontada.domains.SquadMember

object ClubDatabase {

    val bossTeamHistoryXI = listOf(
        SquadMember("boss_c", "Sir A. Ferguson", "All-Time", Position.COACH, "Scotland", "BOSS", tactics = 99, motivation = 99),
        SquadMember("boss1", "Pelé", "All-Time", Position.FORWARD, "Brazil", "BOSS", ovr = 98, stat1 = 95, stat2 = 96, stat3 = 96), // PAC, SHO, DRI
        SquadMember("boss2", "L. Messi", "All-Time", Position.FORWARD, "Argentina", "BOSS", ovr = 99, stat1 = 92, stat2 = 93, stat3 = 96),
        SquadMember("boss3", "C. Ronaldo", "All-Time", Position.FORWARD, "Portugal", "BOSS", ovr = 99, stat1 = 93, stat2 = 94, stat3 = 92),
        SquadMember("boss4", "D. Maradona", "All-Time", Position.MIDFIELD, "Argentina", "BOSS", ovr = 97, stat1 = 93, stat2 = 85, stat3 = 96), // PAS, STA, VIS
        SquadMember("boss5", "Z. Zidane", "All-Time", Position.MIDFIELD, "France", "BOSS", ovr = 96, stat1 = 94, stat2 = 82, stat3 = 96),
        SquadMember("boss6", "L. Matthäus", "All-Time", Position.MIDFIELD, "Germany", "BOSS", ovr = 93, stat1 = 90, stat2 = 93, stat3 = 88),
        SquadMember("boss7", "P. Maldini", "All-Time", Position.DEFENDER, "Italy", "BOSS", ovr = 94, stat1 = 95, stat2 = 82, stat3 = 96), // DEF, PHY, AWA
        SquadMember("boss8", "F. Beckenbauer", "All-Time", Position.DEFENDER, "Germany", "BOSS", ovr = 93, stat1 = 94, stat2 = 84, stat3 = 95),
        SquadMember("boss9", "F. Baresi", "All-Time", Position.DEFENDER, "Italy", "BOSS", ovr = 93, stat1 = 95, stat2 = 80, stat3 = 94),
        SquadMember("boss10", "Cafu", "All-Time", Position.DEFENDER, "Brazil", "BOSS", ovr = 90, stat1 = 88, stat2 = 86, stat3 = 90),
        SquadMember("boss11", "L. Yashin", "All-Time", Position.GOALKEEPER, "Russia", "BOSS", ovr = 94, stat1 = 96, stat2 = 95, stat3 = 92) // REF, POS, HAN
    )

    val clubs: Map<String, List<SquadMember>> = mapOf(

        "FC Barcelona (09-11)" to listOf(
            SquadMember("barc_c", "P. Guardiola", "2011", Position.COACH, "Spain", "FCB", tactics = 99, motivation = 92),
            SquadMember("barc1", "L. Messi", "2011", Position.FORWARD, "Argentina", "FCB", ovr = 94, stat1 = 92, stat2 = 93, stat3 = 95),
            SquadMember("barc2", "D. Villa", "2011", Position.FORWARD, "Spain", "FCB", ovr = 89, stat1 = 86, stat2 = 90, stat3 = 88),
            SquadMember("barc3", "Pedro", "2011", Position.FORWARD, "Spain", "FCB", ovr = 85, stat1 = 87, stat2 = 83, stat3 = 84),
            SquadMember("barc4", "Xavi", "2011", Position.MIDFIELD, "Spain", "FCB", ovr = 90, stat1 = 93, stat2 = 84, stat3 = 94),
            SquadMember("barc5", "A. Iniesta", "2011", Position.MIDFIELD, "Spain", "FCB", ovr = 89, stat1 = 90, stat2 = 80, stat3 = 93),
            SquadMember("barc6", "S. Busquets", "2011", Position.MIDFIELD, "Spain", "FCB", ovr = 83, stat1 = 82, stat2 = 81, stat3 = 84),
            SquadMember("barc7", "D. Alves", "2011", Position.DEFENDER, "Brazil", "FCB", ovr = 86, stat1 = 84, stat2 = 80, stat3 = 85),
            SquadMember("barc8", "G. Piqué", "2011", Position.DEFENDER, "Spain", "FCB", ovr = 85, stat1 = 86, stat2 = 82, stat3 = 84),
            SquadMember("barc9", "C. Puyol", "2011", Position.DEFENDER, "Spain", "FCB", ovr = 86, stat1 = 88, stat2 = 84, stat3 = 86),
            SquadMember("barc10", "E. Abidal", "2011", Position.DEFENDER, "France", "FCB", ovr = 82, stat1 = 84, stat2 = 78, stat3 = 83),
            SquadMember("barc11", "V. Valdés", "2011", Position.GOALKEEPER, "Spain", "FCB", ovr = 85, stat1 = 88, stat2 = 84, stat3 = 82)
        ),

        "Real Madrid (16-18)" to listOf(
            SquadMember("rm_c", "Z. Zidane", "2018", Position.COACH, "France", "RMA", tactics = 93, motivation = 98),
            SquadMember("rm1", "C. Ronaldo", "2018", Position.FORWARD, "Portugal", "RMA", ovr = 94, stat1 = 90, stat2 = 93, stat3 = 90),
            SquadMember("rm2", "K. Benzema", "2018", Position.FORWARD, "France", "RMA", ovr = 86, stat1 = 78, stat2 = 84, stat3 = 82),
            SquadMember("rm3", "G. Bale", "2018", Position.FORWARD, "Wales", "RMA", ovr = 89, stat1 = 94, stat2 = 87, stat3 = 86),
            SquadMember("rm4", "L. Modrić", "2018", Position.MIDFIELD, "Croatia", "RMA", ovr = 89, stat1 = 89, stat2 = 89, stat3 = 90),
            SquadMember("rm5", "T. Kroos", "2018", Position.MIDFIELD, "Germany", "RMA", ovr = 90, stat1 = 88, stat2 = 75, stat3 = 88),
            SquadMember("rm6", "Casemiro", "2018", Position.MIDFIELD, "Brazil", "RMA", ovr = 85, stat1 = 75, stat2 = 88, stat3 = 76),
            SquadMember("rm7", "Marcelo", "2018", Position.DEFENDER, "Brazil", "RMA", ovr = 87, stat1 = 80, stat2 = 78, stat3 = 82),
            SquadMember("rm8", "S. Ramos", "2018", Position.DEFENDER, "Spain", "RMA", ovr = 90, stat1 = 88, stat2 = 84, stat3 = 86),
            SquadMember("rm9", "R. Varane", "2018", Position.DEFENDER, "France", "RMA", ovr = 85, stat1 = 84, stat2 = 79, stat3 = 83),
            SquadMember("rm10", "D. Carvajal", "2018", Position.DEFENDER, "Spain", "RMA", ovr = 84, stat1 = 82, stat2 = 79, stat3 = 81),
            SquadMember("rm11", "K. Navas", "2018", Position.GOALKEEPER, "Costa Rica", "RMA", ovr = 85, stat1 = 87, stat2 = 82, stat3 = 80)
        ),

        "Bayern Munich (2013)" to listOf(
            SquadMember("bay_c", "J. Heynckes", "2013", Position.COACH, "Germany", "BAY", tactics = 95, motivation = 92),
            SquadMember("bay1", "M. Mandžukić", "2013", Position.FORWARD, "Croatia", "BAY", ovr = 83, stat1 = 75, stat2 = 82, stat3 = 76),
            SquadMember("bay2", "A. Robben", "2013", Position.FORWARD, "Netherlands", "BAY", ovr = 88, stat1 = 93, stat2 = 85, stat3 = 92),
            SquadMember("bay3", "F. Ribéry", "2013", Position.FORWARD, "France", "BAY", ovr = 90, stat1 = 93, stat2 = 84, stat3 = 93),
            SquadMember("bay4", "T. Müller", "2013", Position.MIDFIELD, "Germany", "BAY", ovr = 85, stat1 = 82, stat2 = 90, stat3 = 84),
            SquadMember("bay5", "B. Schweinsteiger", "2013", Position.MIDFIELD, "Germany", "BAY", ovr = 88, stat1 = 86, stat2 = 88, stat3 = 85),
            SquadMember("bay6", "J. Martínez", "2013", Position.MIDFIELD, "Spain", "BAY", ovr = 83, stat1 = 78, stat2 = 84, stat3 = 76),
            SquadMember("bay7", "P. Lahm", "2013", Position.DEFENDER, "Germany", "BAY", ovr = 87, stat1 = 86, stat2 = 75, stat3 = 88),
            SquadMember("bay8", "J. Boateng", "2013", Position.DEFENDER, "Germany", "BAY", ovr = 83, stat1 = 84, stat2 = 85, stat3 = 80),
            SquadMember("bay9", "Dante", "2013", Position.DEFENDER, "Brazil", "BAY", ovr = 84, stat1 = 85, stat2 = 82, stat3 = 82),
            SquadMember("bay10", "D. Alaba", "2013", Position.DEFENDER, "Austria", "BAY", ovr = 81, stat1 = 82, stat2 = 74, stat3 = 78),
            SquadMember("bay11", "M. Neuer", "2013", Position.GOALKEEPER, "Germany", "BAY", ovr = 86, stat1 = 88, stat2 = 85, stat3 = 84)
        ),

        "AC Milan (03-07)" to listOf(
            SquadMember("mil_c", "C. Ancelotti", "2007", Position.COACH, "Italy", "ACM", tactics = 94, motivation = 95),
            SquadMember("mil1", "A. Shevchenko", "2004", Position.FORWARD, "Ukraine", "ACM", ovr = 88, stat1 = 87, stat2 = 89, stat3 = 85),
            SquadMember("mil2", "F. Inzaghi", "2007", Position.FORWARD, "Italy", "ACM", ovr = 85, stat1 = 80, stat2 = 88, stat3 = 82),
            SquadMember("mil3", "Kaká", "2007", Position.FORWARD, "Brazil", "ACM", ovr = 90, stat1 = 92, stat2 = 87, stat3 = 93),
            SquadMember("mil4", "A. Pirlo", "2006", Position.MIDFIELD, "Italy", "ACM", ovr = 87, stat1 = 92, stat2 = 78, stat3 = 94),
            SquadMember("mil5", "G. Gattuso", "2006", Position.MIDFIELD, "Italy", "ACM", ovr = 84, stat1 = 75, stat2 = 94, stat3 = 70),
            SquadMember("mil6", "C. Seedorf", "2007", Position.MIDFIELD, "Netherlands", "ACM", ovr = 85, stat1 = 86, stat2 = 84, stat3 = 85),
            SquadMember("mil7", "Cafu", "2004", Position.DEFENDER, "Brazil", "ACM", ovr = 88, stat1 = 84, stat2 = 82, stat3 = 88),
            SquadMember("mil8", "A. Nesta", "2004", Position.DEFENDER, "Italy", "ACM", ovr = 90, stat1 = 92, stat2 = 84, stat3 = 94),
            SquadMember("mil9", "P. Maldini", "2003", Position.DEFENDER, "Italy", "ACM", ovr = 92, stat1 = 94, stat2 = 80, stat3 = 96),
            SquadMember("mil10", "K. Kaladze", "2005", Position.DEFENDER, "Georgia", "ACM", ovr = 81, stat1 = 82, stat2 = 84, stat3 = 80),
            SquadMember("mil11", "Dida", "2005", Position.GOALKEEPER, "Brazil", "ACM", ovr = 85, stat1 = 88, stat2 = 84, stat3 = 82)
        ),

        "Liverpool (18-19)" to listOf(
            SquadMember("liv_c", "J. Klopp", "2019", Position.COACH, "Germany", "LIV", tactics = 94, motivation = 98),
            SquadMember("liv1", "M. Salah", "2019", Position.FORWARD, "Egypt", "LIV", ovr = 88, stat1 = 92, stat2 = 84, stat3 = 89),
            SquadMember("liv2", "S. Mané", "2019", Position.FORWARD, "Senegal", "LIV", ovr = 86, stat1 = 93, stat2 = 80, stat3 = 87),
            SquadMember("liv3", "R. Firmino", "2019", Position.FORWARD, "Brazil", "LIV", ovr = 86, stat1 = 77, stat2 = 83, stat3 = 86),
            SquadMember("liv4", "Fabinho", "2019", Position.MIDFIELD, "Brazil", "LIV", ovr = 85, stat1 = 80, stat2 = 88, stat3 = 82),
            SquadMember("liv5", "J. Henderson", "2019", Position.MIDFIELD, "England", "LIV", ovr = 82, stat1 = 82, stat2 = 88, stat3 = 80),
            SquadMember("liv6", "G. Wijnaldum", "2019", Position.MIDFIELD, "Netherlands", "LIV", ovr = 82, stat1 = 81, stat2 = 86, stat3 = 80),
            SquadMember("liv7", "A. Robertson", "2019", Position.DEFENDER, "Scotland", "LIV", ovr = 81, stat1 = 78, stat2 = 80, stat3 = 80),
            SquadMember("liv8", "V. van Dijk", "2019", Position.DEFENDER, "Netherlands", "LIV", ovr = 85, stat1 = 85, stat2 = 84, stat3 = 86),
            SquadMember("liv9", "J. Matip", "2019", Position.DEFENDER, "Cameroon", "LIV", ovr = 81, stat1 = 82, stat2 = 76, stat3 = 80),
            SquadMember("liv10", "T. Alexander-Arnold", "2019", Position.DEFENDER, "England", "LIV", ovr = 80, stat1 = 76, stat2 = 70, stat3 = 78),
            SquadMember("liv11", "Alisson", "2019", Position.GOALKEEPER, "Brazil", "LIV", ovr = 85, stat1 = 87, stat2 = 84, stat3 = 82)
        ),

        "Dortmund (12-13)" to listOf(
            SquadMember("dor_c", "J. Klopp", "2013", Position.COACH, "Germany", "BVB", tactics = 92, motivation = 96),
            SquadMember("dor1", "R. Lewandowski", "2013", Position.FORWARD, "Poland", "BVB", ovr = 83, stat1 = 80, stat2 = 82, stat3 = 84),
            SquadMember("dor2", "M. Reus", "2013", Position.FORWARD, "Germany", "BVB", ovr = 84, stat1 = 90, stat2 = 83, stat3 = 85),
            SquadMember("dor3", "J. Błaszczykowski", "2013", Position.FORWARD, "Poland", "BVB", ovr = 80, stat1 = 91, stat2 = 74, stat3 = 82),
            SquadMember("dor4", "M. Götze", "2013", Position.MIDFIELD, "Germany", "BVB", ovr = 84, stat1 = 82, stat2 = 75, stat3 = 86),
            SquadMember("dor5", "I. Gündoğan", "2013", Position.MIDFIELD, "Germany", "BVB", ovr = 80, stat1 = 83, stat2 = 78, stat3 = 82),
            SquadMember("dor6", "S. Bender", "2013", Position.MIDFIELD, "Germany", "BVB", ovr = 79, stat1 = 74, stat2 = 85, stat3 = 70),
            SquadMember("dor7", "M. Schmelzer", "2013", Position.DEFENDER, "Germany", "BVB", ovr = 78, stat1 = 78, stat2 = 79, stat3 = 76),
            SquadMember("dor8", "M. Hummels", "2013", Position.DEFENDER, "Germany", "BVB", ovr = 85, stat1 = 86, stat2 = 80, stat3 = 86),
            SquadMember("dor9", "N. Subotić", "2013", Position.DEFENDER, "Serbia", "BVB", ovr = 82, stat1 = 84, stat2 = 82, stat3 = 78),
            SquadMember("dor10", "Ł. Piszczek", "2013", Position.DEFENDER, "Poland", "BVB", ovr = 82, stat1 = 80, stat2 = 82, stat3 = 80),
            SquadMember("dor11", "R. Weidenfeller", "2013", Position.GOALKEEPER, "Germany", "BVB", ovr = 82, stat1 = 84, stat2 = 80, stat3 = 78)
        ),
        "Manchester United (1999)" to listOf(
            SquadMember("utd_c", "Sir A. Ferguson", "1999", Position.COACH, "Scotland", "MUN", tactics = 96, motivation = 99),
            SquadMember("utd1", "A. Cole", "1999", Position.FORWARD, "England", "MUN", ovr = 86, stat1 = 88, stat2 = 85, stat3 = 83), // PAC, SHO, DRI
            SquadMember("utd2", "D. Yorke", "1999", Position.FORWARD, "Trinidad and Tobago", "MUN", ovr = 86, stat1 = 85, stat2 = 87, stat3 = 84),
            SquadMember("utd3", "R. Giggs", "1999", Position.FORWARD, "Wales", "MUN", ovr = 89, stat1 = 92, stat2 = 80, stat3 = 90),
            SquadMember("utd4", "D. Beckham", "1999", Position.MIDFIELD, "England", "MUN", ovr = 89, stat1 = 94, stat2 = 92, stat3 = 92), // PAS, STA, VIS
            SquadMember("utd5", "R. Keane", "1999", Position.MIDFIELD, "Ireland", "MUN", ovr = 88, stat1 = 86, stat2 = 94, stat3 = 84),
            SquadMember("utd6", "P. Scholes", "1999", Position.MIDFIELD, "England", "MUN", ovr = 88, stat1 = 91, stat2 = 85, stat3 = 90),
            SquadMember("utd7", "G. Neville", "1999", Position.DEFENDER, "England", "MUN", ovr = 84, stat1 = 84, stat2 = 82, stat3 = 85), // DEF, PHY, AWA
            SquadMember("utd8", "J. Stam", "1999", Position.DEFENDER, "Netherlands", "MUN", ovr = 88, stat1 = 89, stat2 = 92, stat3 = 86),
            SquadMember("utd9", "R. Johnsen", "1999", Position.DEFENDER, "Norway", "MUN", ovr = 82, stat1 = 83, stat2 = 80, stat3 = 82),
            SquadMember("utd10", "D. Irwin", "1999", Position.DEFENDER, "Ireland", "MUN", ovr = 84, stat1 = 84, stat2 = 81, stat3 = 85),
            SquadMember("utd11", "P. Schmeichel", "1999", Position.GOALKEEPER, "Denmark", "MUN", ovr = 90, stat1 = 92, stat2 = 88, stat3 = 86) // REF, POS, HAN
        ),

        "Arsenal (03-04)" to listOf(
            SquadMember("ars_c", "A. Wenger", "2004", Position.COACH, "France", "ARS", tactics = 95, motivation = 92),
            SquadMember("ars1", "T. Henry", "2004", Position.FORWARD, "France", "ARS", ovr = 93, stat1 = 94, stat2 = 91, stat3 = 93),
            SquadMember("ars2", "D. Bergkamp", "2004", Position.FORWARD, "Netherlands", "ARS", ovr = 90, stat1 = 78, stat2 = 88, stat3 = 92),
            SquadMember("ars3", "R. Pires", "2004", Position.FORWARD, "France", "ARS", ovr = 88, stat1 = 85, stat2 = 84, stat3 = 89),
            SquadMember("ars4", "F. Ljungberg", "2004", Position.MIDFIELD, "Sweden", "ARS", ovr = 86, stat1 = 82, stat2 = 88, stat3 = 84),
            SquadMember("ars5", "P. Vieira", "2004", Position.MIDFIELD, "France", "ARS", ovr = 90, stat1 = 87, stat2 = 92, stat3 = 88),
            SquadMember("ars6", "G. Silva", "2004", Position.MIDFIELD, "Brazil", "ARS", ovr = 85, stat1 = 82, stat2 = 88, stat3 = 80),
            SquadMember("ars7", "Lauren", "2004", Position.DEFENDER, "Cameroon", "ARS", ovr = 82, stat1 = 83, stat2 = 84, stat3 = 80),
            SquadMember("ars8", "S. Campbell", "2004", Position.DEFENDER, "England", "ARS", ovr = 88, stat1 = 89, stat2 = 91, stat3 = 86),
            SquadMember("ars9", "K. Touré", "2004", Position.DEFENDER, "Ivory Coast", "ARS", ovr = 84, stat1 = 85, stat2 = 84, stat3 = 82),
            SquadMember("ars10", "A. Cole", "2004", Position.DEFENDER, "England", "ARS", ovr = 87, stat1 = 86, stat2 = 82, stat3 = 88),
            SquadMember("ars11", "J. Lehmann", "2004", Position.GOALKEEPER, "Germany", "ARS", ovr = 85, stat1 = 88, stat2 = 84, stat3 = 82)
        ),

        "Inter Milan (2010)" to listOf(
            SquadMember("int_c", "J. Mourinho", "2010", Position.COACH, "Portugal", "INT", tactics = 98, motivation = 97),
            SquadMember("int1", "D. Milito", "2010", Position.FORWARD, "Argentina", "INT", ovr = 86, stat1 = 78, stat2 = 88, stat3 = 82),
            SquadMember("int2", "S. Eto'o", "2010", Position.FORWARD, "Cameroon", "INT", ovr = 87, stat1 = 90, stat2 = 85, stat3 = 88),
            SquadMember("int3", "G. Pandev", "2010", Position.FORWARD, "Macedonia", "INT", ovr = 82, stat1 = 80, stat2 = 79, stat3 = 84),
            SquadMember("int4", "W. Sneijder", "2010", Position.MIDFIELD, "Netherlands", "INT", ovr = 88, stat1 = 90, stat2 = 82, stat3 = 92),
            SquadMember("int5", "J. Zanetti", "2010", Position.MIDFIELD, "Argentina", "INT", ovr = 87, stat1 = 84, stat2 = 94, stat3 = 82),
            SquadMember("int6", "E. Cambiasso", "2010", Position.MIDFIELD, "Argentina", "INT", ovr = 86, stat1 = 85, stat2 = 88, stat3 = 84),
            SquadMember("int7", "Maicon", "2010", Position.DEFENDER, "Brazil", "INT", ovr = 88, stat1 = 86, stat2 = 88, stat3 = 85),
            SquadMember("int8", "Lúcio", "2010", Position.DEFENDER, "Brazil", "INT", ovr = 87, stat1 = 88, stat2 = 89, stat3 = 86),
            SquadMember("int9", "W. Samuel", "2010", Position.DEFENDER, "Argentina", "INT", ovr = 85, stat1 = 88, stat2 = 86, stat3 = 85),
            SquadMember("int10", "C. Chivu", "2010", Position.DEFENDER, "Romania", "INT", ovr = 82, stat1 = 84, stat2 = 78, stat3 = 82),
            SquadMember("int11", "J. César", "2010", Position.GOALKEEPER, "Brazil", "INT", ovr = 88, stat1 = 90, stat2 = 86, stat3 = 84)
        ),

        "Juventus (14-15)" to listOf(
            SquadMember("juv_c", "M. Allegri", "2015", Position.COACH, "Italy", "JUV", tactics = 93, motivation = 89),
            SquadMember("juv1", "C. Tevez", "2015", Position.FORWARD, "Argentina", "JUV", ovr = 87, stat1 = 84, stat2 = 88, stat3 = 89),
            SquadMember("juv2", "Á. Morata", "2015", Position.FORWARD, "Spain", "JUV", ovr = 82, stat1 = 85, stat2 = 80, stat3 = 82),
            SquadMember("juv3", "P. Pogba", "2015", Position.FORWARD, "France", "JUV", ovr = 85, stat1 = 84, stat2 = 80, stat3 = 88),
            SquadMember("juv4", "A. Pirlo", "2015", Position.MIDFIELD, "Italy", "JUV", ovr = 88, stat1 = 93, stat2 = 68, stat3 = 94),
            SquadMember("juv5", "A. Vidal", "2015", Position.MIDFIELD, "Chile", "JUV", ovr = 86, stat1 = 84, stat2 = 92, stat3 = 82),
            SquadMember("juv6", "C. Marchisio", "2015", Position.MIDFIELD, "Italy", "JUV", ovr = 84, stat1 = 85, stat2 = 88, stat3 = 84),
            SquadMember("juv7", "S. Lichtsteiner", "2015", Position.DEFENDER, "Switzerland", "JUV", ovr = 82, stat1 = 80, stat2 = 84, stat3 = 81),
            SquadMember("juv8", "L. Bonucci", "2015", Position.DEFENDER, "Italy", "JUV", ovr = 84, stat1 = 86, stat2 = 82, stat3 = 85),
            SquadMember("juv9", "G. Chiellini", "2015", Position.DEFENDER, "Italy", "JUV", ovr = 86, stat1 = 88, stat2 = 89, stat3 = 84),
            SquadMember("juv10", "P. Evra", "2015", Position.DEFENDER, "France", "JUV", ovr = 82, stat1 = 82, stat2 = 78, stat3 = 83),
            SquadMember("juv11", "G. Buffon", "2015", Position.GOALKEEPER, "Italy", "JUV", ovr = 86, stat1 = 88, stat2 = 90, stat3 = 82)
        ),

        "Manchester City (17-18)" to listOf(
            SquadMember("mci_c", "P. Guardiola", "2018", Position.COACH, "Spain", "MCI", tactics = 98, motivation = 91),
            SquadMember("mci1", "S. Agüero", "2018", Position.FORWARD, "Argentina", "MCI", ovr = 89, stat1 = 88, stat2 = 90, stat3 = 89),
            SquadMember("mci2", "R. Sterling", "2018", Position.FORWARD, "England", "MCI", ovr = 85, stat1 = 93, stat2 = 79, stat3 = 86),
            SquadMember("mci3", "L. Sané", "2018", Position.FORWARD, "Germany", "MCI", ovr = 84, stat1 = 94, stat2 = 80, stat3 = 85),
            SquadMember("mci4", "K. De Bruyne", "2018", Position.MIDFIELD, "Belgium", "MCI", ovr = 90, stat1 = 92, stat2 = 88, stat3 = 93),
            SquadMember("mci5", "D. Silva", "2018", Position.MIDFIELD, "Spain", "MCI", ovr = 88, stat1 = 89, stat2 = 78, stat3 = 91),
            SquadMember("mci6", "Fernandinho", "2018", Position.MIDFIELD, "Brazil", "MCI", ovr = 85, stat1 = 82, stat2 = 86, stat3 = 80),
            SquadMember("mci7", "K. Walker", "2018", Position.DEFENDER, "England", "MCI", ovr = 83, stat1 = 82, stat2 = 84, stat3 = 80),
            SquadMember("mci8", "J. Stones", "2018", Position.DEFENDER, "England", "MCI", ovr = 80, stat1 = 82, stat2 = 78, stat3 = 80),
            SquadMember("mci9", "N. Otamendi", "2018", Position.DEFENDER, "Argentina", "MCI", ovr = 84, stat1 = 85, stat2 = 86, stat3 = 82),
            SquadMember("mci10", "F. Delph", "2018", Position.DEFENDER, "England", "MCI", ovr = 79, stat1 = 78, stat2 = 76, stat3 = 79),
            SquadMember("mci11", "Ederson", "2018", Position.GOALKEEPER, "Brazil", "MCI", ovr = 84, stat1 = 86, stat2 = 82, stat3 = 83)
        ),

        "Chelsea (04-05)" to listOf(
            SquadMember("che_c", "J. Mourinho", "2005", Position.COACH, "Portugal", "CHE", tactics = 98, motivation = 98),
            SquadMember("che1", "D. Drogba", "2005", Position.FORWARD, "Ivory Coast", "CHE", ovr = 86, stat1 = 84, stat2 = 85, stat3 = 82),
            SquadMember("che2", "J. Cole", "2005", Position.FORWARD, "England", "CHE", ovr = 84, stat1 = 85, stat2 = 78, stat3 = 88),
            SquadMember("che3", "D. Duff", "2005", Position.FORWARD, "Ireland", "CHE", ovr = 83, stat1 = 88, stat2 = 76, stat3 = 85),
            SquadMember("che4", "F. Lampard", "2005", Position.MIDFIELD, "England", "CHE", ovr = 89, stat1 = 88, stat2 = 92, stat3 = 86),
            SquadMember("che5", "C. Makélélé", "2005", Position.MIDFIELD, "France", "CHE", ovr = 87, stat1 = 84, stat2 = 90, stat3 = 80),
            SquadMember("che6", "Tiago", "2005", Position.MIDFIELD, "Portugal", "CHE", ovr = 82, stat1 = 82, stat2 = 84, stat3 = 80),
            SquadMember("che7", "P. Ferreira", "2005", Position.DEFENDER, "Portugal", "CHE", ovr = 81, stat1 = 82, stat2 = 78, stat3 = 82),
            SquadMember("che8", "J. Terry", "2005", Position.DEFENDER, "England", "CHE", ovr = 88, stat1 = 90, stat2 = 88, stat3 = 89),
            SquadMember("che9", "R. Carvalho", "2005", Position.DEFENDER, "Portugal", "CHE", ovr = 87, stat1 = 88, stat2 = 84, stat3 = 87),
            SquadMember("che10", "W. Gallas", "2005", Position.DEFENDER, "France", "CHE", ovr = 85, stat1 = 86, stat2 = 84, stat3 = 84),
            SquadMember("che11", "P. Čech", "2005", Position.GOALKEEPER, "Czech Republic", "CHE", ovr = 88, stat1 = 90, stat2 = 88, stat3 = 85)
        ),

        "Ajax (94-95)" to listOf(
            SquadMember("ajx_c", "L. van Gaal", "1995", Position.COACH, "Netherlands", "AJX", tactics = 96, motivation = 88),
            SquadMember("ajx1", "P. Kluivert", "1995", Position.FORWARD, "Netherlands", "AJX", ovr = 86, stat1 = 85, stat2 = 87, stat3 = 84),
            SquadMember("ajx2", "J. Litmanen", "1995", Position.FORWARD, "Finland", "AJX", ovr = 88, stat1 = 82, stat2 = 88, stat3 = 89),
            SquadMember("ajx3", "M. Overmars", "1995", Position.FORWARD, "Netherlands", "AJX", ovr = 87, stat1 = 94, stat2 = 80, stat3 = 88),
            SquadMember("ajx4", "C. Seedorf", "1995", Position.MIDFIELD, "Netherlands", "AJX", ovr = 86, stat1 = 87, stat2 = 88, stat3 = 86),
            SquadMember("ajx5", "E. Davids", "1995", Position.MIDFIELD, "Netherlands", "AJX", ovr = 85, stat1 = 84, stat2 = 92, stat3 = 82),
            SquadMember("ajx6", "R. de Boer", "1995", Position.MIDFIELD, "Netherlands", "AJX", ovr = 84, stat1 = 85, stat2 = 84, stat3 = 85),
            SquadMember("ajx7", "F. de Boer", "1995", Position.DEFENDER, "Netherlands", "AJX", ovr = 86, stat1 = 87, stat2 = 82, stat3 = 88),
            SquadMember("ajx8", "D. Blind", "1995", Position.DEFENDER, "Netherlands", "AJX", ovr = 87, stat1 = 88, stat2 = 80, stat3 = 89),
            SquadMember("ajx9", "W. Bogarde", "1995", Position.DEFENDER, "Netherlands", "AJX", ovr = 81, stat1 = 82, stat2 = 84, stat3 = 80),
            SquadMember("ajx10", "M. Reiziger", "1995", Position.DEFENDER, "Netherlands", "AJX", ovr = 82, stat1 = 81, stat2 = 80, stat3 = 83),
            SquadMember("ajx11", "E. van der Sar", "1995", Position.GOALKEEPER, "Netherlands", "AJX", ovr = 87, stat1 = 89, stat2 = 88, stat3 = 85)
        ),

        "Paris SG (25-26)" to listOf(
            SquadMember("psg_c", "Luis Enrique", "2026", Position.COACH, "Spain", "PSG", tactics = 95, motivation = 92),
            // Forwards: PAC, SHO, DRI
            SquadMember("psg1", "Khvicha Kvaratskhelia", "2026", Position.FORWARD, "Georgia", "PSG", ovr = 87, stat1 = 86, stat2 = 80, stat3 = 88),
            SquadMember("psg2", "Ousmane Dembélé", "2026", Position.FORWARD, "France", "PSG", ovr = 86, stat1 = 92, stat2 = 82, stat3 = 89),
            SquadMember("psg3", "Bradley Barcola", "2026", Position.FORWARD, "France", "PSG", ovr = 85, stat1 = 94, stat2 = 80, stat3 = 86),
            // Midfielders: PAS, STA, VIS
            SquadMember("psg4", "Vitinha", "2026", Position.MIDFIELD, "Portugal", "PSG", ovr = 89, stat1 = 86, stat2 = 85, stat3 = 90),
            SquadMember("psg5", "João Neves", "2026", Position.MIDFIELD, "Portugal", "PSG", ovr = 84, stat1 = 82, stat2 = 92, stat3 = 83),
            SquadMember("psg6", "Warren Zaïre-Emery", "2026", Position.MIDFIELD, "France", "PSG", ovr = 83, stat1 = 80, stat2 = 88, stat3 = 82),
            // Defenders: DEF, PHY, AWA
            SquadMember("psg7", "Marquinhos", "2026", Position.DEFENDER, "Brazil", "PSG", ovr = 87, stat1 = 89, stat2 = 80, stat3 = 88),
            SquadMember("psg8", "Achraf Hakimi", "2026", Position.DEFENDER, "Morocco", "PSG", ovr = 85, stat1 = 82, stat2 = 78, stat3 = 84),
            SquadMember("psg9", "Nuno Mendes", "2026", Position.DEFENDER, "Portugal", "PSG", ovr = 86, stat1 = 80, stat2 = 77, stat3 = 82),
            SquadMember("psg10", "Willian Pacho", "2026", Position.DEFENDER, "Ecuador", "PSG", ovr = 86, stat1 = 86, stat2 = 86, stat3 = 84),
            // Goalkeeper: REF, POS, HAN
            SquadMember("psg11", "Lucas Chevalier", "2026", Position.GOALKEEPER, "France", "PSG", ovr = 86, stat1 = 88, stat2 = 85, stat3 = 84)
        ),

        "Atlético Madrid (20-21)" to listOf(
            SquadMember("atm_c", "D. Simeone", "2021", Position.COACH, "Argentina", "ATM", tactics = 96, motivation = 98),
            SquadMember("atm1", "L. Suárez", "2021", Position.FORWARD, "Uruguay", "ATM", ovr = 87, stat1 = 70, stat2 = 90, stat3 = 83), // PAC, SHO, DRI
            SquadMember("atm2", "J. Félix", "2021", Position.FORWARD, "Portugal", "ATM", ovr = 81, stat1 = 81, stat2 = 81, stat3 = 85),
            SquadMember("atm3", "A. Correa", "2021", Position.FORWARD, "Argentina", "ATM", ovr = 82, stat1 = 85, stat2 = 79, stat3 = 86),
            SquadMember("atm4", "Koke", "2021", Position.MIDFIELD, "Spain", "ATM", ovr = 85, stat1 = 86, stat2 = 93, stat3 = 85), // PAS, STA, VIS
            SquadMember("atm5", "Saúl", "2021", Position.MIDFIELD, "Spain", "ATM", ovr = 84, stat1 = 79, stat2 = 85, stat3 = 80),
            SquadMember("atm6", "M. Llorente", "2021", Position.MIDFIELD, "Spain", "ATM", ovr = 82, stat1 = 81, stat2 = 88, stat3 = 82),
            SquadMember("atm7", "J. Giménez", "2021", Position.DEFENDER, "Uruguay", "ATM", ovr = 84, stat1 = 86, stat2 = 83, stat3 = 85), // DEF, PHY, AWA
            SquadMember("atm8", "S. Savić", "2021", Position.DEFENDER, "Montenegro", "ATM", ovr = 84, stat1 = 86, stat2 = 80, stat3 = 86),
            SquadMember("atm9", "K. Trippier", "2021", Position.DEFENDER, "England", "ATM", ovr = 83, stat1 = 80, stat2 = 71, stat3 = 79),
            SquadMember("atm10", "M. Hermoso", "2021", Position.DEFENDER, "Spain", "ATM", ovr = 80, stat1 = 83, stat2 = 76, stat3 = 81),
            SquadMember("atm11", "J. Oblak", "2021", Position.GOALKEEPER, "Slovenia", "ATM", ovr = 91, stat1 = 90, stat2 = 90, stat3 = 92) // REF, POS, HAN
        ),

    )
}