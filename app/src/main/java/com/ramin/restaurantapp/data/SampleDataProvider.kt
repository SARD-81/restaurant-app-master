package com.ramin.restaurantapp.data

object SampleDataProvider {
    fun foodItems(): List<FoodEntity> = listOf(
        FoodEntity(
            name = "پیتزا مارگاریتا",
            categoryLevel1 = "فست فود",
            categoryLevel2 = "پیتزا",
            description = "خمیر تازه ایتالیایی با سس مخصوص گوجه فرنگی، پنیر موزارلا و ریحان تازه.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1548365328-5473d2fb5aeb",
                "https://images.unsplash.com/photo-1513104890138-7c749659a591"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-5s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "پیتزا پپرونی",
            categoryLevel1 = "فست فود",
            categoryLevel2 = "پیتزا",
            description = "پیتزای لذیذ با پپرونی دودی، پنیر کشدار و سبزیجات تازه.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1601925260078-8f299b5f0f12",
                "https://images.unsplash.com/photo-1478145046317-39f10e56b5e9"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-10s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "ساندویچ مرغ گریل",
            categoryLevel1 = "فست فود",
            categoryLevel2 = "ساندویچ",
            description = "ساندویچ مرغ گریل شده با سس مخصوص، کاهو ترد و نان بروشتای تازه.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1606755962773-0e6e66f59cde",
                "https://images.unsplash.com/photo-1606755962879-0e8af2fa2a52"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-15s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "دوغ نعناع",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "سرد",
            description = "دوغ سنتی محلی با نعناع تازه و تخم شربتی خنک کننده.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1527169402691-feff5539e52c",
                "https://images.unsplash.com/photo-1510627498534-cf7e9002facc"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-3s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "چای زعفران",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "گرم",
            description = "چای سیاه اصیل ایرانی با عطر زعفران ناب خراسان.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1497636577773-f1231844b336",
                "https://images.unsplash.com/photo-1451748266019-10c1b83d9740"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-12s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "لوبیا پلو",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "برنج دانه بلند با گوشت گوساله، لوبیا سبز، سس گوجه فرنگی و ادویه های معطر.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd",
                "https://images.unsplash.com/photo-1493770348161-369560ae357d"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-7s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "کشک بادمجان",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "بادمجان کبابی با کشک محلی، نعناع داغ و پیاز داغ کاراملی شده.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1627308595187-9d0a4d410d8c",
                "https://images.unsplash.com/photo-1612874742237-6526221588db"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-9s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "چلوکباب سلطانی",
            categoryLevel1 = "کباب",
            categoryLevel2 = null,
            description = "چلوکباب سلطانی با برنج ایرانی، کره حیوانی و گوجه کبابی.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1608036489893-d7f49a7f0c5b",
                "https://images.unsplash.com/photo-1568605114967-8130f3a36994"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-20s.mp4"
            ).joinToString(separator = "|")
        ),
        FoodEntity(
            name = "سالاد یونانی",
            categoryLevel1 = "سالاد",
            categoryLevel2 = null,
            description = "سالاد تازه با گوجه گیلاسی، خیار، پنیر فتا و زیتون کالاماتا.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1540420773420-3366772f4999",
                "https://images.unsplash.com/photo-1504674900247-0877df9cc836"
            ).joinToString(separator = "|"),
            videoUrls = listOf(
                "https://samplelib.com/lib/preview/mp4/sample-30s.mp4"
            ).joinToString(separator = "|")
        )
    )
}
