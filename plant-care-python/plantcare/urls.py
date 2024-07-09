from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('plants/', include('plants.urls')),
    path('plant/<int:id>/', include('singleplant.urls')),
    path('', include('home.urls')),
    path('soils/', include('soils.urls')),
    path('soils/<int:id>', include('singlesoil.urls'), name='soil_detail'),
    path('register/', include('customers.urls')),

]
