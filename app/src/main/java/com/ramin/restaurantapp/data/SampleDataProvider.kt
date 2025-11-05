package com.ramin.restaurantapp.data

object SampleDataProvider {

    fun foodItems(): List<FoodEntity> = listOf(
        FoodEntity(
            name = "پیتزا مخصوص کلاسیک",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "پیتزا",
            description = "خمیر دست‌ساز نازک با سس گوجه، پنیر موزارلا و مخلوط گوشت دودی. همراه با ریحان تازه و سس مخصوص سرو می‌شود.",
            photo = listOf(
                "https://images.unsplash.com/photo-1548365328-5473d2fb5aeb?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1513104890138-7c749659a591?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-5s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "پیتزا مرغ و قارچ",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "پیتزا",
            description = "مرغ مزه‌دار شده با قارچ تازه، فلفل دلمه‌ای و پنیر چدار. گزینه‌ای محبوب برای طرفداران غذاهای سبک‌تر.",
            photo = listOf(
                "https://images.unsplash.com/photo-1601925260078-8f299b5f0f12?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1478145046317-39f10e56b5e9?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-10s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "ساندویچ استیک و پنیر",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "ساندویچ",
            description = "نان باگت داغ با استیک گریل‌شده، پیاز کاراملی و پنیر گودا که با سس اختصاصی رستوران تکمیل می‌شود.",
            photo = listOf(
                "https://images.unsplash.com/photo-1606755962773-0e6e66f59cde?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1606755962879-0e8af2fa2a52?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-15s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "برگر دوبل زعفرانی",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "برگر",
            description = "دو لایه گوشت گوساله آبدار با پنیر گودا، سس زعفرانی و نان بریوش کره‌ای. همراه با سیب‌زمینی تنوری سرو می‌شود.",
            photo = listOf(
                "https://images.unsplash.com/photo-1550317138-10000687a72b?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1550547660-d9450f859349?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-12s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "پاستا آلفردو با مرغ دودی",
            categoryLevel1 = "فست‌فود",
            categoryLevel2 = "پاستا",
            description = "فِتوسینی تازه با سس آلفردوی خامه‌ای، مرغ دودی و قارچ کره‌ای. با چیپس پارمزان و جعفری تازه تزئین شده است.",
            photo = listOf(
                "https://images.unsplash.com/photo-1525755662778-989cce38d9ce?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1551183053-bf91a1d81141?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-7s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "آب‌میوه طبیعی انار",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "سرد",
            description = "انار تازه فشرده شده با کمی عسل و یخ خرد شده؛ نوشیدنی‌ای سرشار از آنتی‌اکسیدان برای روزهای گرم.",
            photo = listOf(
                "https://images.unsplash.com/photo-1527169402691-feff5539e52c?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1510627498534-cf7e9002facc?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-3s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "موکتل زردآلو و ریحان",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "سرد",
            description = "ترکیبی خوش‌عطر از زردآلوی تازه، ریحان معطر و آب گازدار. نوشیدنی‌ای سبک و خنک برای شروع یک شب زیبا.",
            photo = listOf(
                "https://images.unsplash.com/photo-1514361892635-6e122620e8d9?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1546171753-97d7676f85d4?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-4s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "چای زعفرانی",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "گرم",
            description = "چای سیاه ایرانی دم شده با زعفران قائنات و هل. عطری گرم و دلنشین برای علاقه‌مندان طعم‌های اصیل ایرانی.",
            photo = listOf(
                "https://images.unsplash.com/photo-1497636577773-f1231844b336?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1451748266019-10c1b83d9740?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-12s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "لاته هل و زعفران",
            categoryLevel1 = "نوشیدنی",
            categoryLevel2 = "گرم",
            description = "قهوه اسپرسوی معطر با شیر بخار داده، ترکیب هل سبز و زعفران. نوشیدنی محبوب برای عصرهای خلوت.",
            photo = listOf(
                "https://images.unsplash.com/photo-1511920170033-f8396924c348?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1509042239860-f550ce710b93?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-8s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "خورشت قورمه‌سبزی",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "سبزی قورمه تازه، گوشت گوسفندی، لوبیا قرمز و لیمو عمانی. همراه با برنج ایرانی و ترشی خانگی سرو می‌شود.",
            photo = listOf(
                "https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1493770348161-369560ae357d?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-7s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "زرشک‌پلو با مرغ زعفرانی",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "ران مرغ ترد با زعفران و کره محلی، سرو شده همراه با برنج زعفرانی و زرشک سرخ‌شده در روغن حیوانی.",
            photo = listOf(
                "https://images.unsplash.com/photo-1473093226795-af9932fe5856?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1604908176997-25cbb1cb31c3?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-9s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "ته‌چین طلایی مرغ و بادمجان",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "لایه‌های برنج زعفرانی، مرغ مزه‌دار و بادمجان کبابی با مغز گردو و خلال پسته. با دوغ محلی سرو می‌شود.",
            photo = listOf(
                "https://images.unsplash.com/photo-1606851090164-5a7a6d1d0210?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1551218808-94e220e084d2?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-11s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "کشک و بادمجان",
            categoryLevel1 = "غذای ایرانی",
            categoryLevel2 = null,
            description = "ترکیب بادمجان کبابی، کشک محلی، نعنا داغ و پیاز داغ. مزه‌ای نوستالژیک با بافتی نرم و خامه‌ای.",
            photo = listOf(
                "https://images.unsplash.com/photo-1627308595187-9d0a4d410d8c?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1612874742237-6526221588db?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-9s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "کباب سلطانی",
            categoryLevel1 = "کباب",
            categoryLevel2 = null,
            description = "یک سیخ کوبیده زعفرانی و یک سیخ برگ گوسفندی با گوجه کبابی و کره محلی. انتخابی مناسب برای مهمان‌های ویژه.",
            photo = listOf(
                "https://images.unsplash.com/photo-1608036489893-d7f49a7f0c5b?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1568605114967-8130f3a36994?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-20s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "جوجه کباب لیمویی",
            categoryLevel1 = "کباب",
            categoryLevel2 = null,
            description = "سینه مرغ لطیف خوابانده شده در آب‌لیمو تازه، زعفران و روغن زیتون. همراه با سبزی تازه و سماق سرو می‌شود.",
            photo = listOf(
                "https://images.unsplash.com/photo-1481931098730-318b6f776db0?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1612872087720-bb876e701348?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-6s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "کباب ماهیچه زعفرانی",
            categoryLevel1 = "کباب",
            categoryLevel2 = null,
            description = "ماهیچه گوسفندی آرام‌پز شده با ادویه‌های معطر و زعفران. با برنج عطری و سبزیجات بخارپز سرو می‌شود.",
            photo = listOf(
                "https://images.unsplash.com/photo-1588167056540-93f64269fbf1?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-13s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "سالاد سزار ایرانی",
            categoryLevel1 = "سالاد",
            categoryLevel2 = null,
            description = "کاهوی رومانی، مرغ سوخاری، پنیر پارمزان و نان تست کره‌ای. با سس مخصوص سزار که به سبک ایرانی بازآفرینی شده است.",
            photo = listOf(
                "https://images.unsplash.com/photo-1540420773420-3366772f4999?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1514516430032-7d5fcd82d77c?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-30s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "سالاد انار و گردو",
            categoryLevel1 = "سالاد",
            categoryLevel2 = null,
            description = "ترکیبی از کاهو فرانسوی، انار دانه شده، گردو کاراملی و پنیر فتا با سس نارنج خانگی.",
            photo = listOf(
                "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-14s.mp4").joinToString("|")
        ),
        FoodEntity(
            name = "سالاد تبوله سبزیجات",
            categoryLevel1 = "سالاد",
            categoryLevel2 = null,
            description = "ترکیبی تازه از بلغور، جعفری، گوجه گیلاسی و لیمو تازه. گزینه‌ای مناسب برای پیش‌غذا یا وعده سبک.",
            photo = listOf(
                "https://images.unsplash.com/photo-1504753793650-d4a2b783c15e?auto=format&fit=crop&w=900&q=80",
                "https://images.unsplash.com/photo-1498837167922-ddd27525d352?auto=format&fit=crop&w=900&q=80"
            ).joinToString("|"),
            video = listOf("https://samplelib.com/lib/preview/mp4/sample-16s.mp4").joinToString("|")
        )
    )
}
