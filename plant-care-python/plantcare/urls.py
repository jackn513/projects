from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('plants/', include('plants.urls')),  # Include app-specific URLs for plants
    path('plant/<int:id>/', include('singleplant.urls')),  # Example for single plant view
    path('', include('home.urls')),  # URL for the homepage
    path('soils/', include('soils.urls')),  # Include app-specific URLs for soils
    path('register/', include('customers.urls')),
]
