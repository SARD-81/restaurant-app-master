package com.ramin.restaurantapp.data

object SampleDataProvider {

    fun foodItems(): List<FoodEntity> = listOf(
        FoodEntity(
            name = "پیتزا مخصوص کلاسیک",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "پیتزا",
            description = "خمیر دست‌ساز نازک با سس گوجه، پنیر موزارلا و مخلوط گوشت دودی. همراه با ریحان تازه و سس مخصوص سرو می‌شود.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1548365328-5473d2fb5aeb",
                "https://images.unsplash.com/photo-1513104890138-7c749659a591"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-5s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "پیتزا مرغ و قارچ",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "پیتزا",
            description = "مرغ مزه‌دار شده با قارچ تازه، فلفل دلمه‌ای و پنیر چدار. گزینه‌ای محبوب برای طرفداران غذاهای سبک‌تر.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1601925260078-8f299b5f0f12",
                "https://images.unsplash.com/photo-1478145046317-39f10e56b5e9"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-10s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "ساندویچ استیک و پنیر",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "ساندویچ",
            description = "نان باگت داغ با استیک گریل‌شده، پیاز کاراملی و پنیر گودا که با سس اختصاصی رستوران تکمیل می‌شود.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1606755962773-0e6e66f59cde",
                "https://images.unsplash.com/photo-1606755962879-0e8af2fa2a52"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-15s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "آب‌میوه طبیعی انار",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "سرد",
            description = "انار تازه فشرده شده با کمی عسل و یخ خرد شده؛ نوشیدنی‌ای سرشار از آنتی‌اکسیدان برای روزهای گرم.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1527169402691-feff5539e52c",
                "https://images.unsplash.com/photo-1510627498534-cf7e9002facc"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-3s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "چای زعفرانی",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "گرم",
            description = "چای سیاه ایرانی دم شده با زعفران قائنات و هل. عطری گرم و دلنشین برای علاقه‌مندان طعم‌های اصیل ایرانی.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1497636577773-f1231844b336",
                "https://images.unsplash.com/photo-1451748266019-10c1b83d9740"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-12s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "خورشت قورمه‌سبزی",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "سبزی قورمه تازه، گوشت گوسفندی، لوبیا قرمز و لیمو عمانی. همراه با برنج ایرانی و ترشی خانگی سرو می‌شود.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd",
                "https://images.unsplash.com/photo-1493770348161-369560ae357d"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-7s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "کشک و بادمجان",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "ترکیب بادمجان کبابی، کشک محلی، نعنا داغ و پیاز داغ. مزه‌ای نوستالژیک با بافتی نرم و خامه‌ای.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1627308595187-9d0a4d410d8c",
                "https://images.unsplash.com/photo-1612874742237-6526221588db"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-9s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "کباب سلطانی",
            categoryLevel1 = "کباب",
            categoryLevel2 = null,
            description = "یک سیخ کوبیده زعفرانی و یک سیخ برگ گوسفندی با گوجه کبابی و کره محلی. انتخابی مناسب برای مهمان‌های ویژه.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1608036489893-d7f49a7f0c5b",
                "https://images.unsplash.com/photo-1568605114967-8130f3a36994"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-20s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "سالاد سزار ایرانی",
            categoryLevel1 = "سالاد",
            categoryLevel2 = null,
            description = "کاهوی رومانی، مرغ سوخاری، پنیر پارمزان و نان تست کره‌ای. با سس مخصوص سزار که به سبک ایرانی بازآفرینی شده است.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1540420773420-3366772f4999",
                "https://images.unsplash.com/photo-1504674900247-0877df9cc836"
            ).joinToString("|"),
            videoUrls = listOf("https://samplelib.com/lib/preview/mp4/sample-30s.mp4").joinToString("|")
        )
    )
}
